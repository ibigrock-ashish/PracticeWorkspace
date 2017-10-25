class ExceptionDemo4 {
	public static void main(String args[]) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException.. Please enter some value other than null" + e);
		}
	}
}