import java.util.Arrays;
import java.util.Comparator;

public class AnagramComaprator implements Comparator<String> {

	public String sortChars(String string) {
		char[] content = string.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
