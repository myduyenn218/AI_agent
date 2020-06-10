
import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
	private String label;
	private Node parent; // for print the path from the start node to goal node
	private double pathCost;// from the root node to this node
	private List<Edge> children = new ArrayList<Edge>();
	private int depth;

	public Node(String label) {
		this.label = label;
		depth = -1;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getLabel() {
		return label;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Edge> getChildren() {
		return children;
	}

	public List<Node> getChildrenNodes() {
		List<Node> result = new ArrayList<Node>();
		for (Edge edge : this.children) {
			result.add(edge.getEnd());
		}
		return result;
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that, double cost) {
		Edge edge = new Edge(this, that, cost);
		this.children.add(edge);
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that) {
		Edge edge = new Edge(this, that);
		this.children.add(edge);
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.label + " " + this.pathCost;
	}

	public void printNode() {

		List<Node> childNode = getChildrenNodes();
//		System.out.println(childNode.size());
		System.out.print(this.getLabel() + "\t");

		for (Node node : childNode) {
			node.printNode();
		}

	}

	public Node findNodeByLable(String label) {
		List<Node> childNode = getChildrenNodes();
		if (this.getLabel().equals(label)) {
			return this;
		}
		for (Node node : childNode) {
			Node n = node.findNodeByLable(label);
			if (n != null)
				return n;
		}
		return null;

	}

	public int compareTo(Node node) {

		return label.compareTo(node.label);
	}
}