import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch implements ISearchAlgo {

	@Override
	public void execute(Node tree) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(tree);
		ArrayList<Node> explprered = new ArrayList<Node>();
		System.out.println("start");

		while (!frontier.isEmpty()) {

			Node node = frontier.poll();
			System.out.print(node.getLabel() + ": " + node.getPathCost() + "\t");
			explprered.add(node);

			List<Edge> edges = node.getChildren();

			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!explprered.contains(child) && !frontier.contains(child)) {
					child.setPathCost(node.getPathCost() + edge.getWeight());
					frontier.add(child);

				} else if (frontier.contains(child) && child.getPathCost() > node.getPathCost()) {
					child.setPathCost(node.getPathCost() + edge.getWeight());
				}
			}

		}

	}

	@Override
	public Node execute(Node tree, String goal) {
		Node g = tree.findNodeByLable(goal);
		if (g == null) {
			return null;
		} else {
			PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
			frontier.add(tree);
			ArrayList<Node> explprered = new ArrayList<Node>();
			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {

				node = frontier.poll();
//				System.out.print(node.getLabel() + ": " + node.getPathCost() + "\t");
				explprered.add(node);

				List<Edge> edges = node.getChildren();

				if (node.getLabel().equals(goal)) {
					return node;
				}

				for (Edge edge : edges) {
					Node child = edge.getEnd();
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						child.setPathCost(node.getPathCost() + edge.getWeight());
						frontier.add(child);

					} else if (frontier.contains(child) && child.getPathCost() > node.getPathCost()) {
						child.setParent(node);
						child.setPathCost(node.getPathCost() + edge.getWeight());
					}
				}

			}
			return null;

		}

	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Node st = tree.findNodeByLable(start);
		Node g = tree.findNodeByLable(goal);
		if (st == null || g == null) {
			return null;
		} else {
			PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
			frontier.add(st);
			ArrayList<Node> explprered = new ArrayList<Node>();
			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {

				node = frontier.poll();
//				System.out.print(node.getLabel() + ": " + node.getPathCost() + "\t");
				explprered.add(node);

				List<Edge> edges = node.getChildren();

				if (node.getLabel().equals(goal)) {
					return node;
				}

				for (Edge edge : edges) {
					Node child = edge.getEnd();
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						child.setPathCost(node.getPathCost() + edge.getWeight());
						frontier.add(child);

					} else if (frontier.contains(child) && child.getPathCost() > node.getPathCost()) {
						child.setParent(node);
						child.setPathCost(node.getPathCost() + edge.getWeight());
					}
				}

			}

			if (g.getParent() == null) {
				return null;
			}
			return null;

		}

	}

}
