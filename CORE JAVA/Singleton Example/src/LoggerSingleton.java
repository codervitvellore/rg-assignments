/**
 * Thread-safe, lazily-initialized Singleton.
 */
public final class LoggerSingleton {

    // Volatile guarantees visibility of changes across threads.
    private static volatile LoggerSingleton instance;

    // Private constructor blocks external instantiation.
    private LoggerSingleton() { }

    /**
     * Global access point.
     * Uses double-checked locking to avoid the cost of synchronization
     * after the instance has been created.
     */
    public static LoggerSingleton getInstance() {
        if (instance == null) {                         // 1st check (no lock)
            synchronized (LoggerSingleton.class) {
                if (instance == null) {                 // 2nd check (with lock)
                    instance = new LoggerSingleton();
                }
            }
        }
        return instance;
    }

    /* Example business method */
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
