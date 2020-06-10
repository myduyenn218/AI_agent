import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node tree) {

		// TODO Auto-generated method stub

		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(tree);
		ArrayList<Node> explprered = new ArrayList<Node>();
		System.out.println("start");
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			System.out.print(node.getLabel() + "\t");
			explprered.add(node);

			List<Node> childNode = node.getChildrenNodes();
			Collections.sort(childNode);

			for (Node child : childNode) {
				if (!explprered.contains(child) && !frontier.contains(child)) {
					frontier.add(child);
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

			Queue<Node> frontier = new LinkedList<Node>();
			frontier.add(tree);
			ArrayList<Node> explprered = new ArrayList<Node>();

			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {
				node = frontier.poll();
				explprered.add(node);
				List<Node> childNode = node.getChildrenNodes();
				Collections.sort(childNode);
				if (node.getLabel().equals(goal)) {
					return node;
				}

				for (Node child : childNode) {
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						frontier.add(child);
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
			Queue<Node> frontier = new LinkedList<Node>();
			frontier.add(st);
			ArrayList<Node> explprered = new ArrayList<Node>();
			boolean flag = false;
			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {
				node = frontier.poll();
				explprered.add(node);

				List<Node> childNode = node.getChildrenNodes();
				Collections.sort(childNode);
				if (node.getLabel().equals(goal) && explprered.contains(st)) {
					flag = true;
					return node;
				}
				for (Node child : childNode) {
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						frontier.add(child);
					}
				}

			}
			if (!flag) {
				return null;
			}
			return null;
		}

	}

}
