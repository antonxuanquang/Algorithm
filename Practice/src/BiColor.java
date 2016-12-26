import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BiColor {
	
	private static class Edge {
		enum Color {
			RED, BLACK;
		}
		
		Color color;
		
		public Edge(Color color) {
			this.color = color; 
		}
	}
	
	private static class UndirectedGraph {
		
		int [][] graph;
		HashSet<Integer> adj;
		
		public UndirectedGraph (int dimension) {
			graph = new int [dimension][dimension];
			adj = new HashSet<Integer>();
		}
		
		public void add(int from, int to) {
			graph[from][to] = 1;
			graph[to][from] = 1;
			adj.add(from);
			adj.add(to);
		}
		
		public int getDimension() {
			return graph[0].length;
		}
		
		public HashSet<Integer> getAdj() {
			return adj;
		}
	}
	
	public static boolean bfs(UndirectedGraph graph) {
		HashSet visitedSet = new HashSet<Integer>();
		boolean isBiColored = true;
		while (visitedSet.size() != graph.getDimension()) {
			for (int i: graph.getAdj()) {
				if (!visitedSet.contains(i)) {
					isBiColored &= bfs(graph, i, visitedSet);
					break;
				}
			}
		}
		return isBiColored;
	}
	
	public static boolean bfs(UndirectedGraph graph, 
			int vertex, HashSet<Integer> visitedSet) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visitedSet.add(vertex);
		queue.add(vertex);
		HashMap<Integer, Boolean> colorMap = new HashMap<Integer, Boolean>();
		boolean isRed = true;
		colorMap.put(vertex, isRed);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			
			// search all the adj
			for (int i = 0; i < graph.getDimension(); i++) {
				if (graph.graph[vertex][i] == 0) continue; // skip non-adjacent verices
				
				// when loop to its self, skip
				if (i == node) {
					continue;
				}					
				// if have not visit
				else if (!visitedSet.contains(node)) {
					// add to queue
					visitedSet.add(i);
					queue.add(i);
					// mark a color different from its parent color
					colorMap.put(i, !colorMap.get(node));
					
				// if visited
				} else {
					// compare its color to its parent color
					if (colorMap.get(i) == colorMap.get(node)) {
						System.out.printf("i: %d, node: %d", i, node);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int dimension = sc.nextInt();
		int adj = sc.nextInt();
		
		UndirectedGraph graph = new UndirectedGraph(dimension);
		
		for (int i = 0; i < adj; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			graph.add(from, to);
			System.out.printf("from %d to %d, i %d\n", from, to, i);
		}
		
		System.out.println("Is bi-colored? " + bfs(graph));		
	}
	
}
