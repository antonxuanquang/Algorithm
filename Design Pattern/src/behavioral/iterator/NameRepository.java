package behavioral.iterator;

public class NameRepository implements Container {

	public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};
	
	public Iterator getIterator() {
		return new NameItorator();
	}
	
	private class NameItorator implements Iterator {
		
		int index;
		
		public boolean hasNext() {
			if (index < names.length) return true;
			return false;
		}

		public Object next() {
			if (hasNext()) return names[index++];
			return null;
		}
		
	}

}
