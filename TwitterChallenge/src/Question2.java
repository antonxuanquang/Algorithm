
public class Question2 {
	
	public static int matrix(int m, int n) {
//		return matrix1(m, n);	
		return matrix2(m, n);
	}
	
	private static int matrix1(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
		int [][] memo = new int[m][n];
		return matrix1(m, n, 0, 0, memo);
	}
	
	private static int matrix1(int m, int n, 
			int r, int c, int[][] memo) {
		
		// out of bound
		if (r == m || c == n) return 0;
		
		// hit the corner, the base case
		if (r == m - 1 && c == n - 1) return 1;
			
		// use memory to store value where we already know the number of path
		if (memo[r][c] > 0) return memo[r][c];
		
		// compute path of the coordinate right to me
		int right = matrix1(m, n, r, c + 1, memo);
		
		// compute path of the coordinate below to me
		int down = matrix1(m, n, r + 1, c, memo);
		
		// compute path of the coordinate diagonal to me
		int diagonal = matrix1(m, n, r + 1, c + 1, memo);
		
		// sum them all
		int result = right + down + diagonal;
		
		// save the number of path in particular coordinate for future
		memo[r][c] = result;
		return result;
	}
	
	private static int matrix2(int m, int n) {
		// special case
		if (m <= 0 || n <= 0) return 0;
		if (m == 1 || n == 1) return 1;
		
		// normal case
		int [][] memo = new int [m][n];
		memo[0][0] = 1;
		
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				// edge coordinate
				if (r - 1 < 0 || c - 1 < 0) memo[r][c] = 1;
				
				// reflect over square diagonal
				// else if (r < n && c < r) memo[r][c] = memo[c][r];  
				
				// inside the grid
				else {
					int left = memo[r - 1][c];
					int up = memo[r][c - 1];
					int diagonal = memo[r - 1][c - 1];
					memo[r][c] = diagonal + left + up;
				}
			}
		}
		return memo[m - 1][n - 1];
	}

	public static void main(String[] args) {
		
		System.out.println(matrix(-5, -5));
		System.out.println(matrix(0, 3));
		System.out.println(matrix(1, 1));
		System.out.println(matrix(3, 0));
		System.out.println(matrix(0, 0));
		System.out.println(matrix(5, 5));
		System.out.println(matrix(20, 40));
		System.out.println(matrix(40, 20));
		System.out.println(matrix(40, 40));
		System.out.println(matrix(1000, 1000));
		System.out.println(matrix(10000, 10000));
//		System.out.println(matrix(100000, 100000));
	}
}
