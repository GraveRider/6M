package greeter;

public class GreeterTest {

    public static void main(String[] args) {
        LithuanianGreeting ltGreeting = new LithuanianGreeting();
        ltGreeting.greet("Jonas", "Jonaitis", 5);

        System.out.println("-------------------------------");

        EnglishGreeting englishGreeting = new EnglishGreeting();
        englishGreeting.greet("Jonas", "Jonaitis", 5);
    }
}
