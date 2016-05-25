
public class Eight {
	public static void main(String args[]) {
		int matrix[][] = {{1,2,0,4,0},
				{5,6,7,8,2},
			    {9,0,11,12,1},
			    {13,14,15,16,4}};

		printMatrix(matrix);		
//		zeroMatrix(matrix);
		setZeros(matrix);
		printMatrix(matrix);
	}
	
	
	/*
	 * 
	 * My Solution
	 * 
	 */
	private static void zeroMatrix(int[][] matrix) {
		boolean [] column_check = new boolean[matrix[0].length];
		
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				// skip zero column
				if (column_check[column]) continue;
				if (matrix[row][column] == 0) {
					column_check[column] = true;
					
					// zero out row and columns
					for (int i = 0; i < matrix.length; i++) 
						matrix[i][column] = 0;
					for (int i = 0; i < matrix[0].length; i++)
						matrix[row][i] = 0;
					break;
				}
			}
		}
	}
	
	/*
	 * 
	 * Book's solution
	 * 
	 */

	private static void setZeros(int matrix[][]) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
		// check if first row has a zero
		for (int column = 0; column < matrix[0].length; column++)
			if (matrix[0][column] == 0) {
				rowHasZero = true;
				break;
			}
		
		// check if first column has a zero
		for (int row = 0; row < matrix.length; row++) {
			if (matrix[row][0] == 0) {
				columnHasZero = true;
				break;
			}
		}
		
		// check for zeros in rows and columns
		for (int row = 1; row < matrix.length; row++) {
			for (int column = 1; column < matrix[0].length; column++) {
				if (matrix[row][column] == 0) {
					matrix[0][column] = 0;
					matrix[row][0] = 0;
				}
			}
		}
		
		// zero out row base on first column
		for (int row = 1; row < matrix.length; row++) {
			if (matrix[row][0] == 0) nullifyRow(matrix, row);
		}
		
		// zero out column base on first row
		for (int column = 1; column < matrix[0].length; column++) {
			if (matrix[0][column] == 0) nullifyColumn(matrix, column);
		}
		
		// zero out first row and column
		if (rowHasZero) nullifyRow(matrix, 0);
		if (columnHasZero) nullifyColumn(matrix, 0);
		
	}
	
	private static void nullifyRow(int[][] matrix, int row) {
		for (int column = 0; column < matrix[0].length; column++) {
			matrix[row][column] = 0;
		}
	}
	
	private static void nullifyColumn(int[][] matrix, int column) {
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][column] = 0;
		}
	}


	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println();
	}
	
	
}
