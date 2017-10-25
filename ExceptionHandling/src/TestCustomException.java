
public class TestCustomException {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		try {
			validate(1);
			System.out.println("rest of the code will proceed normally ...");
		} catch (InvalidAgeException r) {
			System.out.println("Invalid Age Exception");
		} catch (Exception m) {
			System.out.println("Exception occured: " + m);
		} finally {
			System.out.println("FInally Block");
		}
		// System.out.println("rest of the code will proceed normally ...");
	}

}