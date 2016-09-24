import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Thirdteen {
	
	/*
	 * 
	 * Stack of Boxes: You have a stack of n boxes, with width w[i], height h[i],
	 * and depth d[i]. The boxes cannot be rotated and can only be stacked on top
	 * of one another if each box in the stack is strictly larger than the box 
	 * above it in width, height, and depth. Implement a method to compute the 
	 * height of the tallest possible stack. The height of a stack is the sum of
	 * the heights of each box.
	 * 
	 */
	
	/*
	 * 
	 * Book's best solution
	 * 
	 */
	
	private static class Box {
		public int width;
		public int height;
		public int depth;
		public Box(int w, int h, int d) {
			width = w;
			height = h;
			depth = d;
		}
		
		public boolean canBeUnder(Box b) {
			if (width > b.width && height > b.height && depth > b.depth) {
				return true;
			}
			return false;
		}
		
		public boolean canBeAbove(Box b) {
			if (b == null) {
				return true;
			}
			if (width < b.width && height < b.height && depth < b.depth) {
				return true;
			}
			return false;		
		}
		
		public String toString() {
			return "Box(" + width + "," + height + "," + depth + ")";
		}
	}

	private static class BoxComparator implements Comparator<Box> {
		
		public int compare(Box x, Box y){
			return y.height - x.height;
		}
	}
	
	public static int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		int[] stackMap = new int[boxes.size()];
		return createStack(boxes, null, 0, stackMap);
	}
	
	public static int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
		if (offset >= boxes.size()) {
			return 0;
		}
		
		/* height with this bottom */
		Box newBottom = boxes.get(offset);
		int heightWithBottom = 0;
		if (bottom == null || newBottom.canBeAbove(bottom)) {
			if (stackMap[offset] == 0) {
				stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
				stackMap[offset] += newBottom.height;
			}
			heightWithBottom = stackMap[offset];
		}
		
		/* without this bottom */
		int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);
		
		return Math.max(heightWithBottom, heightWithoutBottom);
	}
	
	public static void main(String[] args) {
		Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStack(boxes);
		System.out.println(height);
	}
	

}
