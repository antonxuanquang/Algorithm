
public class Nine {
	public static void main(String[] args) {
		System.out.println(isRotated("waterbottle", "tlewaterbot"));
		System.out.println(isRotated("neckalake", "alakeneck"));
		System.out.println(isRotated("neckalake", "alakefeck"));
		System.out.println(isRotated("neckalake", "akeneckal"));
	}

	private static boolean isRotated(String string, String string2) {
		
		String xy = string2 + string2;
		
		return xy.contains(string);
	}
}
