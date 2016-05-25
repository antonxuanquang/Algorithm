
public class Three {
	public static void main(String args[]) {
		System.out.println(URLify("Hello World  ", 13));
	}

	private static String URLify(String string, int length) {
		// TODO Auto-generated method stub
		char [] char_array = new char[length];
		int string_counter = 0; 
		int array_counter = 0;
		while (string_counter < length) {
			int val = string.charAt(string_counter);
			if (val == ' ') {
				char_array[array_counter++] = '%';
				char_array[array_counter++] = '2';
				char_array[array_counter++] = '0';
				length -= 2;
			} else {
				char_array[array_counter++] = (char)val;
			}
			string_counter++;
		}
		return new String(char_array);
	}
}
