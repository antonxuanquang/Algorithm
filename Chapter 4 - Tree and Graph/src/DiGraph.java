import java.util.ArrayList;
import java.util.HashMap;

public class DiGraph {
	private class Node {
		private String label;
		private ArrayList<Node> adj;
		boolean visited = false;
		
		public Node(String label) {
			this.label = label;
			adj = new ArrayList<Node>();
		}
		
		public void add (Node vertice) {
			adj.add(vertice);
		}
		
		public boolean contains(String label) {
			for (Node node: adj) {
				if (label.equals(node.label)) return true;
			}
			return false;
		}
		
		public String getLabel() {
			return label;
		}
	}
	
	HashMap<String, Node> graph;
	
	public DiGraph() {
		graph = new HashMap<String, Node>();
	}
	
	private void falsifyVertices() {
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			node.visited = false;
		}
	}
	
	public void addEdge(String from, String to) {
		if (graph.containsKey(from)) {
			Node fromNode = graph.get(from);
			if (fromNode.contains(to)) return;
			Node toNode;
			if (graph.containsKey(to)) {
				toNode = graph.get(to);
			} else {
				toNode = new Node(to);
				graph.put(to, toNode);
			}
			fromNode.add(toNode);
		} else {
			Node fromNode = new Node(from);
			Node toNode;
			if (graph.containsKey(to)) {
				toNode = graph.get(to);
			} else {
				toNode = new Node(to);
				graph.put(to, toNode);
			}
			fromNode.add(toNode);
			graph.put(from, fromNode);
		}
	}
	
	public Node getVirtex(String label) {
		return graph.get(label);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			result.append(node.label + ":");
			for (Node child: node.adj) {
				result.append(" " + child.label);
			}
			result.append("\n");
		}
		
		return result.toString();
	}
	
	public void dfsSearch (Node root) { 
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			node.visited = false;
		}
		dfsSearchRecursion(root);
	}
	
	private void dfsSearchRecursion(Node root) {
		if (graph.get(root.label) == null) return;
		root.visited = true;
		System.out.println(root.label);
		for (Node node: root.adj) {
			if (!node.visited) dfsSearchRecursion(node);
		}
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
		graph.dfsSearch(graph.getVirtex("1"));
	}
}
