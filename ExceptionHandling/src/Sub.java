public class Sub extends Super {
	void show() throws Exception {
		super.show();
		System.out.println("Child Class");
		throw new Exception("not valid in child");
	}

	public static void main(String[] args) {
		try {
			Super s = new Sub();
			s.show();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
}