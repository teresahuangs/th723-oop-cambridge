public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class.
    private Singleton() {}

    // Public method to access the singleton instance.
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
