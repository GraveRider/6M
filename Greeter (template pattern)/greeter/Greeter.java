package greeter;

public abstract class Greeter {
	
	public void greet(String name, String surname, int howManyTimes) {
		if (howManyTimes != 0) {
			System.out.println(welcome() + ", " + name + " " + surname + "!");
			greet(name, surname, howManyTimes - 1);
		}
	}

	public abstract String welcome();
}
