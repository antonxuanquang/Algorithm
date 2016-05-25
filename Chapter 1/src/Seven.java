
public class Seven {
	public static void main (String[] args) {
//		int matrix[][] = {{2,3,7,6},
//		                  {1,1,6,7},
//		                  {9,0,5,1},
//		                  {8,9,10,11}};
		int matrix[][] = {{1,2,3,4},
				{5,6,7,8},
			    {9,10,11,12},
			    {13,14,15,16}};

		printMatrix(matrix);
		rotateMatrix(matrix);
		printMatrix(matrix);
		
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println();
	}

	private static void rotateMatrix(int[][] matrix) {
		rotateMatrix(matrix, 0, matrix.length - 1);
	}

	private static void rotateMatrix(int[][] matrix, int start, int end) {
		if ((end - start) < 1 || matrix.length != matrix[0].length) return;
		for (int i = start; i < end; i++) {
			/*
			 * 
			 * MY shift was wrong
			 * 
			 */
			
//			System.out.println("start: " + start + "; end = " + end + "; leftshift = " + leftshift);
//			System.out.println("[end - leftshift] = " + (end - leftshift));
//			int temp = 	matrix[end - leftshift][start];
//			matrix[end - leftshift][start] = matrix[end][end - leftshift];
//			matrix[end][end - leftshift] = matrix[leftshift][end];
//			matrix[leftshift][end] = matrix[start][leftshift];
//			matrix[start][leftshift] = temp;
			
			
			/*
			 * 
			 * The book's shift was right
			 * 
			 */
			int offset = i - start;
			
			int top = matrix[start][i];
			//left -> top
			matrix[start][i] = matrix[end - offset][start];
			// bottom -> left
			matrix[end - offset][start] = matrix[end][end - offset];
			//right -> bottom
			matrix[end][end - offset] = matrix[i][end];
			//top -> right
			matrix[i][end] = top;
			
		}
		rotateMatrix(matrix, start + 1, end -1);
	}
}
