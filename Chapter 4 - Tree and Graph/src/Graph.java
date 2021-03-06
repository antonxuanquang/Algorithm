import java.util.ArrayList;
import java.util.HashMap;


public class Graph {
	
	HashMap<String, Node> graph;
	
	public Graph() {
		graph = new HashMap<String, Node>();
	}
	
	public Node getVirtex(String label) {
		return graph.get(label);
	}
	
	public void addEdge(String virtex1, String virtex2) {
		if (graph.containsKey(virtex1)) {
			Node node1 = graph.get(virtex1);
			Node node2;
			if (graph.containsKey(virtex2)) {
				node2 = graph.get(virtex2);
			} else {
				node2 = new Node(virtex2);
				graph.put(virtex2, node2);
			}
			if (!node1.contains(virtex2)) node1.add(node2);
			if (!node2.contains(virtex1)) node2.add(node1);
		} else {
			Node node1 = new Node(virtex1);
			graph.put(virtex1, node1);
			Node node2;
			if (graph.containsKey(virtex2)) {
				node2 = graph.get(node1);
			} else {
				node2 = new Node(virtex2);
				graph.put(virtex2, node2);
			}
			if (!node1.contains(virtex2)) node1.add(node2);
			if (!node2.contains(virtex1)) node2.add(node1);
		}
	}
	
	public void dfsSearch (Node root) { 
		for (String key: graph.keySet()) {
			Node node = graph.get(key);
			node.visited = false;
		}
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
	
	
	
	public static void main (String[] args) {
		Graph graph = new Graph();
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
