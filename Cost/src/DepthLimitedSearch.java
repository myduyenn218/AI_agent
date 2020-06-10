import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {

	public void execute(Node tree, int limitedDepth) {

		int depth = 0;

		Stack<Node> frontier = new Stack<Node>();

		frontier.add(tree);
		ArrayList<Node> explprered = new ArrayList<Node>();

		System.out.println("start");

		while (!frontier.isEmpty()) {

			Node node = frontier.pop();
			if (node.getDepth() == -1) {
				node.setDepth(depth);
			} else {
				depth = node.getDepth();
			}
			System.out.print(node.getLabel() + "\t");
			explprered.add(node);

			List<Node> childNode = node.getChildrenNodes();
			if (childNode != null) {
				depth++;
			}
			if (depth <= limitedDepth) {
				Collections.sort(childNode);
				Collections.reverse(childNode);

				for (Node child : childNode) {

					if (!explprered.contains(child) && !frontier.contains(child)) {
						frontier.push(child);
						if (child.getDepth() == -1) {
							child.setDepth(depth);
						}
					}
				}
			}

		}

	}

	public Node execute(Node tree, String goal, int limitedDepth) {

		int depth = 0;

		Stack<Node> frontier = new Stack<Node>();

		frontier.add(tree);
		ArrayList<Node> explprered = new ArrayList<Node>();

		System.out.println("start");

		while (!frontier.isEmpty()) {

			Node node = frontier.pop();
			if (node.getDepth() == -1) {
				node.setDepth(depth);
			} else {
				depth = node.getDepth();
			}
//			System.out.print(node.getLabel() + "\t");
			explprered.add(node);
			if (node.getLabel().equals(goal)) {
				return node;
			}
			List<Node> childNode = node.getChildrenNodes();
			if (childNode != null) {
				depth++;
			}
			if (depth <= limitedDepth) {

				Collections.sort(childNode);
				Collections.reverse(childNode);

				for (Node child : childNode) {

					if (!explprered.contains(child) && !frontier.contains(child)) {
						frontier.push(child);
						child.setParent(node);
						if (child.getDepth() == -1) {
							child.setDepth(depth);
						}
					}
				}
			}

		}
		return null;
	}

}
