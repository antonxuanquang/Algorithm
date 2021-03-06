import javax.swing.RootPaneContainer;

public class One {
	/*
	 * 
	 * Given a directed graph, design an algorithm to find out whether
	 * there is a route between two nodes.
	 * 
	 */
	
	public static boolean routable(DiGraph graph, Node node1, Node node2) {
		graph.falsifyVertices();
		boolean first = bfs(node1, node2);
		graph.falsifyVertices();
		return first || bfs(node2, node1);  
	}
	
	private static boolean dfs(Node from, Node to) {
		if (from == null) return false;
		from.visited = true;
		System.out.println(from.getLabel());
		if (from == to) return true;
		for (Node node: from.getAdj()) {
			if (!node.visited) return dfs(node, to);
		}
		return false;
	}
	
	private static boolean bfs(Node from, Node to) {
		MyQueue<Node> queue = new MyQueue<Node>();
		queue.enqueue(from);
		while (!queue.isEmpty()) {
			Node nextNode = queue.dequeue();
			nextNode.visited = true;
			System.out.println(nextNode.getLabel());
			if (from == to) return true;
			for (Node node: nextNode.getAdj()) {
				if (!node.visited) {
					queue.enqueue(node);
					node.visited = true;
				}
			}
		}
		return false;
	}
	
	public static void main (String[] args) {
		DiGraph graph = new DiGraph();
		graph.addEdge("1", "6");
		graph.addEdge("1", "6");
		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("2", "4");
		graph.addEdge("6", "5");
		graph.addEdge("2", "6");
		graph.addEdge("3", "3");
		graph.addEdge("4", "6");
		graph.addEdge("4", "5");
		graph.addEdge("1", "4");
		System.out.println(graph.toString());
		System.out.println(routable(graph, graph.getVirtex("1"), graph.getVirtex("2")));
	}
}
