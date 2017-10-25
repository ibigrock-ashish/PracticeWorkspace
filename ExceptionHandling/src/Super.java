public class Super {
	void show() throws Exception {
		System.out.println("Parent class");
		throw new ArrayIndexOutOfBoundsException ("not valid in parent");
	}
}
