
public class SingletonTest {

    public static void main(String[] args) {
       Singleton single = Singleton.createSingleton();
       Singleton anotherSingle = Singleton.createSingleton();

        System.out.println(single == anotherSingle);
    }
}
