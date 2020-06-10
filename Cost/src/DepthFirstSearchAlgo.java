import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node tree) {
		Stack<Node> frontier = new Stack<Node>();

		frontier.add(tree);
		ArrayList<Node> explprered = new ArrayList<Node>();

		System.out.println("start");
		while (!frontier.isEmpty()) {
			Node node = frontier.pop();
			System.out.print(node.getLabel() + "\t");
			explprered.add(node);

			List<Node> childNode = node.getChildrenNodes();
			Collections.sort(childNode);
			Collections.reverse(childNode);

			for (Node child : childNode) {
				if (!explprered.contains(child) && !frontier.contains(child)) {
					frontier.push(child);
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
			Stack<Node> frontier = new Stack<Node>();
			frontier.add(tree);
			ArrayList<Node> explprered = new ArrayList<Node>();

			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {
				node = frontier.pop();
				explprered.add(node);

				List<Node> childNode = node.getChildrenNodes();
				Collections.sort(childNode);
				Collections.reverse(childNode);
				if (node.getLabel().equals(goal)) {
					return node;
				}

				for (Node child : childNode) {
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						frontier.push(child);
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
			Stack<Node> frontier = new Stack<Node>();
			frontier.add(st);
			ArrayList<Node> explprered = new ArrayList<Node>();
			boolean flag = false;
			System.out.println("start");
			Node node = null;
			while (!frontier.isEmpty()) {
				node = frontier.pop();
				explprered.add(node);

				List<Node> childNode = node.getChildrenNodes();
				Collections.sort(childNode);
				Collections.reverse(childNode);
				if (node.getLabel().equals(goal) && explprered.contains(st)) {
					flag = true;
					return node;
				}

				for (Node child : childNode) {
					if (!explprered.contains(child) && !frontier.contains(child)) {
						child.setParent(node);
						frontier.push(child);
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
