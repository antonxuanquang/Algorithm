import java.util.ArrayList;

public class Node {
	private String label;
	private ArrayList<Node> adj;
	boolean visited = false;
	boolean visiting = false;
	
	public Node(String label) {
		this.label = label;
		adj = new ArrayList<Node>();
	}
	
	public void add (Node vertice) {
		if (!contains(vertice.getLabel())) adj.add(vertice);
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
	
	public ArrayList<Node> getAdj() {
		return adj;
	}
	
}