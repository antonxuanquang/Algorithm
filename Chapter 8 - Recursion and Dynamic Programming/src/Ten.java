import java.util.Arrays;


public class Ten {
	
	/*
	 * 
	 * Paint Fill: Implement the "paint fill" function that one might 
	 * see on many image editing programs. That is, given a screen
	 * (represented by a two-dimensional array of colors), a point, 
	 * and a new color, fill the surrounding area until the color 
	 * changes from the original color
	 * 
	 */
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void paintFill(int[][] picture, Point point, int color) {
		if (picture[point.x][point.y] == color) return;
		paintFill(picture, point, picture[point.x][point.y], color);		
	}
	
	
	private static void paintFill(int[][] picture, Point point, int oldColor, int newColor) {
		int x = point.x;
		int y = point.y;
		
		if (x < 0 || y < 0 || x == picture.length || y == picture[0].length) {
			return;	// out-of-bound
		}
		if (picture[x][y] == oldColor ) {
			picture[x][y] = newColor;
			paintFill(picture, new Point(x + 1, y), oldColor, newColor);
			paintFill(picture, new Point(x - 1, y), oldColor, newColor);
			paintFill(picture, new Point(x, y + 1), oldColor, newColor);
			paintFill(picture, new Point(x, y - 1), oldColor, newColor);
		}
	}


	public static void main (String[]args) {
		
		int[][] picture = {
				{0,0,0,1,2,1,1,1,3,4},
				{0,0,1,1,1,2,3,1,1,1},
				{0,0,3,1,5,1,1,1,1,4},
				{0,0,3,1,1,1,2,3,1,1}
		};
		for (int[] array: picture) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println();
		paintFill(picture, new Point(3,4), 5);
		for (int[] array: picture) {
			System.out.println(Arrays.toString(array));
		}
		
	}

}
