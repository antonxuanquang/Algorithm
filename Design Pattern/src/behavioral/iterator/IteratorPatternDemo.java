package behavioral.iterator;

public class IteratorPatternDemo {
	public static void main(String[]strings) {
		NameRepository nameRepository = new NameRepository();
		
		for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println(name);
		}
	}
}
