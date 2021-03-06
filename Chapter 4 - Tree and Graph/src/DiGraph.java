import java.awt.SecondaryLoop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DiGraph {
	HashMap<String, Node> graph;
	
	public DiGraph() {
		graph = new HashMap<String, Node>();
	}
	
	public void falsifyVertices() {
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			node.visited = false;
			node.visiting = false;
		}
	}
	
	private Node getOrCreateNode(String label) {
		if (!graph.containsKey(label)) {
			Node node = new Node(label);
			graph.put(label, node);
		}
		return graph.get(label);
	}
	
	public void addEdge(String from, String to) {
		Node first = getOrCreateNode(from);
		Node second = getOrCreateNode(to);
		first.add(second);
	}
	
	public Node getVirtex(String label) {
		return graph.get(label);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			result.append(node.getLabel() + ":");
			for (Node child: node.getAdj()) {
				result.append(" " + child.getLabel());
			}
			result.append("\n");
		}
		
		return result.toString();
	}
	
	public void dfsSearch (Node root) { 
		falsifyVertices();
		dfsSearchRecursion(root);
	}
	
	private void dfsSearchRecursion(Node root) {
		if (graph.get(root.getLabel()) == null) return;
		root.visited = true;
		System.out.println(root.getLabel());
		for (Node node: root.getAdj()) {
			if (!node.visited) dfsSearchRecursion(node);
		}
	}
	
	public void bfsSearch (Node root) { 
		falsifyVertices();
		bfsSearchRecursion(root);
	}
	
	private void bfsSearchRecursion(Node root) {
		MyQueue<Node> queue = new MyQueue<Node>();
		root.visited = true;
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node next = queue.dequeue();
			System.out.println(next.getLabel());
			for (Node node: next.getAdj()) {
				if (!node.visited) {
					node.visited = true;
					queue.enqueue(node);
				}
			}
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
		graph.dfsSearch(graph.getVirtex("2"));
		System.out.println("\n\n\n");
		graph.bfsSearch(graph.getVirtex("1"));
	}
}
