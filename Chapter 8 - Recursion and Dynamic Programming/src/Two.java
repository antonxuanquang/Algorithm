import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

import javax.swing.RowFilter;

public class Two {

	/*
	 * 
	 * Robot in Grid: Imagine a robot sitting on the upper left corner of grid
	 * with r rows and c columns. The robot can only move in two directions,
	 * right and down, but certain cells are "off limits" such that the robot
	 * cannot step on them. Design an algorithm to find a path for the robot
	 * from the top left to the bottom right.
	 */

	private static class Point {
		public int row;
		public int column;

		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
		
		public boolean equal(Point that) {
			return this.row == that.row && this.column == that.column;
		}
		
		public String toString() {
			return "(" + row + ", " + column + ")";
		}
	}

	public static void path(Point[] offGrids, ArrayList<Point> stack, 
			int row, int column) {
		path(offGrids, new Point(0, 0), stack,
				row, column);
	}

	private static void path(Point[] offGrids,
			Point startPoint, ArrayList<Point> stack, int row, int column) {
//		System.out.println(startPoint);
		if (inTheGrids(startPoint, offGrids)) return;
		if (startPoint.row == row && startPoint.column == column) {
			stack.add(startPoint);
			return;
		}
		
		Point nextCoordinator;
		if (startPoint.row < row) {
			nextCoordinator = new Point(startPoint.row + 1, startPoint.column);
			path(offGrids, nextCoordinator, stack, row, column);
			if (!stack.isEmpty()) {
				stack.add(startPoint);
				return;
			}
		}
		
		if (startPoint.column < column) {
			nextCoordinator = new Point(startPoint.row, startPoint.column + 1);
			path(offGrids, nextCoordinator, stack, row, column);
			if (!stack.isEmpty()) {
				stack.add(startPoint);
				return;
			}
		}
	}

	private static boolean inTheGrids(Point startPoint, Point[] offGrids) {
		for (Point coor: offGrids) {
			if (coor.equal(startPoint)) return true;
		}
		return false;
	}
	
	/*
	 * 
	 * Book's Approach
	 * 
	 */
	
	public static ArrayList<Point> getPath(Point[] offGrids, int row, int column) {
		
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failPoints = new HashSet<Point>();
		if (getPath(offGrids, row, column, path, failPoints)) {
			return path;
		}
		return null;
	}
	
	private static boolean getPath(Point[] offGrids, int row, int column,
			ArrayList<Point> path, HashSet<Point> failPoints) {
		Point point = new Point(row, column);
		
		if (row < 0 || column < 0 || inTheGrids(point, offGrids)) return false;
		
		boolean isAtOrigin = (row == 0) && (column == 0);
		
		if (failPoints.contains(point)) return false;
		
		if (isAtOrigin || getPath(offGrids, row - 1, column, path, failPoints) ||
				getPath(offGrids, row, column - 1, path, failPoints)) {
			path.add(point);
			return true;
		}
		failPoints.add(point);
		return false;
	}

	public static void main (String[]strings) {
		ArrayList<Point> stack = new ArrayList<Two.Point>();
		Point[] offGrids = {
				new Point(1, 1),
				new Point(1, 3),
				new Point(2, 0),
				new Point(2, 4),
				new Point(3, 2),
//				new Point(3, 4),
				new Point(4, 3)};
		path(offGrids, stack, 5, 4);
		for (Point coor: stack) {
			System.out.println(coor);
		}
		ArrayList<Point> path = getPath(offGrids, 5, 4);
		for (Point point: path) System.out.println(point);
	}

}
