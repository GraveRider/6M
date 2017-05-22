
public class Singleton {

    private static Singleton single;

    private Singleton() {

    }

    public static Singleton createSingleton() {
        if (single == null) {
            return single = new Singleton();
        }
        return single;
    }
}
