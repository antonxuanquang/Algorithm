
public class Two {
	/*
	 * 
	 * Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that
	 * is passed in as a double, print the binary representation. If the number
	 * cannot be represented accurately in binary with at most 32 characters, 
	 * print "ERROR."
	 * 
	 */
	
	public static String binaryToString(double input) {
		if (input >= 1 || input <= 0) return "ERROR";
		StringBuilder builder = new StringBuilder(".");
		
		while (input > 0) {
			if (builder.length() >= 32) {
				return "ERROR";
			}
			double r = input * 2;
			if (r >= 1) {
				builder.append(1);
				input = r - 1;
			} else {
				builder.append(0);
				input = r;
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(binaryToString(0.100));
		System.out.println(binaryToString(1.0/1024));
		System.out.println(Integer.parseInt("1001000", 2));
	}
}
