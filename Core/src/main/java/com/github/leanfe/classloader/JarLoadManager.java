package com.github.leanfe.classloader;

import com.github.leanfe.core.instance.InstanceManager;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class JarLoadManager {
    private static final List<JavaApp> loadedApps = new ArrayList<>();

    public static void loadAllApps() {
        File files = new File(InstanceManager.getInstance().getDataFolder(), "apps");
        if (!files.isFile()) files.delete();
        if (!files.exists()) files.mkdir();

        Arrays.stream(Objects.requireNonNull(files.listFiles())).forEach(JarLoadManager::loadApp);
    }

    public static CompletableFuture<JavaApp> loadApp(File jar) {
        String jarName = jar.getName();

        System.out.printf("Try load %s !", jarName);

        CompletableFuture<JavaApp> future = new CompletableFuture<>();
        AtomicReference<JavaApp> appRef = new AtomicReference<>();
        AtomicReference<Thread> threadRef = new AtomicReference<>();
        CompletableFuture.runAsync(() -> {
            try {
                File jarFile = new File(InstanceManager.getInstance().getDataFolder(), jarName + ".jar");
                URLClassLoader classLoader = new URLClassLoader(new URL[] { jarFile.toURI().toURL() });
                Class<?> mainClass = null;
                for (String className : getClassNames(jarFile)) {
                    Class<?> cls = classLoader.loadClass(className);
                    try {
                        Method mainMethod = cls.getMethod("main", String[].class);
                        int modifiers = mainMethod.getModifiers();
                        if (java.lang.reflect.Modifier.isPublic(modifiers) && java.lang.reflect.Modifier.isStatic(modifiers)) {
                            mainClass = cls;
                            break;
                        }
                    } catch (NoSuchMethodException | SecurityException ex) {
                        // Ignore - class doesn't have a main method
                    }
                }
                if (mainClass == null) {
                    System.err.printf("Damn, can't find main method in app with name: %s", jarName);
                    return;
                }

                JavaApp app = new JavaApp(mainClass);
                appRef.set(app);
                loadedApps.add(app);
                app.runAsync().thenRun(() -> {
                    loadedApps.remove(app);
                    if (threadRef.get() != null) {
                        threadRef.get().interrupt();
                    }
                });
                future.complete(app);
            } catch (Exception ex) {
                future.completeExceptionally(ex);
            }
        });

        future.thenAccept(app -> threadRef.set(Thread.currentThread()));
        return future;
    }

    public void unloadApp(JavaApp app) {
        app.unload();
    }

    private static String[] getClassNames(File jarFile) throws Exception {
        List<String> classNames = new ArrayList<>();
        try (JarFile jar = new JarFile(jarFile)) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
                    continue;
                }
                String className = entry.getName().substring(0, entry.getName().length() - ".class".length()).replace('/', '.');
                classNames.add(className);
            }
        }

        return classNames.toArray(new String[classNames.size()]);
    }

    private static final class JavaApp {
        private final Class<?> mainClass;
        private final AtomicBoolean running;

        public JavaApp(Class<?> mainClass) {
            this.mainClass = mainClass;
            this.running = new AtomicBoolean(false);
        }

        public CompletableFuture<Void> runAsync() {
            CompletableFuture<Void> future = new CompletableFuture<>();
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Try run main method!");

                    running.set(true);
                    Method mainMethod = mainClass.getMethod("main", String[].class);
                    mainMethod.invoke(null, (Object) new String[] {});
                    future.complete(null);
                } catch (Exception ex) {
                    System.out.printf("ERROR! LOG: %s", ex.getMessage());
                    future.completeExceptionally(ex);
                }
            });
            thread.start();
            return future;
        }

        public void unload() {
            running.set(false);
        }
    }
}