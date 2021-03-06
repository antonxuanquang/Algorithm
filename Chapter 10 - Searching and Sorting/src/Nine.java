import java.util.Arrays;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;


public class Nine {

	/*
	 * 
	 * Sorted Matrix Search: Given an M x N matrix in which each row and 
	 * each column is sorted in ascending order, write a method to find an
	 * element
	 * 
	 */
	
	private static class Coordinate {
		private int row, column;
		
		public Coordinate(int row, int column) {
			this.row = row;
			this.column = column;
		}
		
		public String toString() {
			return "(" + row + ", " + column + ")";
		}
	}
	
	public static Coordinate searchMatrix(int[][] matrix, int number) {
		int rowLength = matrix.length -1;
		if (rowLength <= 0) return new Coordinate(-1, -1);
		int columnLength = matrix[0].length - 1;
		
		int row = 0;
		int column = 0;
		while (row <= rowLength) {
			int columnSearch = searchRow(matrix[row], number);
			if (matrix[row][columnSearch] == number) return new Coordinate(row, columnSearch);
			else if (matrix[row][columnSearch] < number) 
				column = columnSearch == columnLength ? columnLength : columnSearch++;
			else if (matrix[row][columnSearch] > number)
				column = columnSearch == 0 ? 0 : columnSearch--;
			int rowSearch = searchColumn(matrix, columnSearch, number);
			if (matrix[rowSearch][columnSearch] == number) return new Coordinate(rowSearch, columnSearch);			
			row++;
		}
		
		return new Coordinate(-1, -1);
	}
	
	private static int searchColumn(int[][] matrix, int column, int number) {
		int top = 0;
		int bottom = matrix.length - 1;

		while (top < bottom) {
			int mid = (top + bottom) / 2;
			if (number == matrix[mid][column]) return mid;
			else if (number < matrix[mid][column]) bottom = mid - 1;
			else if (number > matrix[mid][column]) top = mid + 1;
		}
		return top;
	}

	private static int searchRow(int[] array, int number) {
		int left = 0;
		int right = array.length - 1;
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (array[mid] == number) return mid;
			else if (number < array[mid]) right = mid - 1;
			else if (number > array[mid]) left = mid + 1;
			
		}
		return left;
	}
	
	/*
	 * 
	 * Book's approach
	 * 
	 */
	public static boolean findElement(int[][] matrix, int element) {
		int row = 0;
		int column = matrix[0].length - 1;
		while (row < matrix.length && column >= 0) {
			if (matrix[row][column] == element) {
				return true;
			} else if (matrix[row][column] > element) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int [][] matrix = {
				{15,20,40,85},
				{20,35,80,95},
				{30,55,95,105},
				{40,80,100,120}};
		
		System.out.println(searchMatrix(matrix, 100));
		System.out.println(findElement(matrix, 100));
	}
}
