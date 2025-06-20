package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "[]";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		StringBuilder sb = new StringBuilder("");
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println("queue - " + queue);
			for (int i = 0; i < size; i++) {
				TreeNode pop = queue.poll();
				if (pop == null)
					sb.append("null,");
				else {
					sb.append(pop.val + ",");
					if (pop.left != null || pop.right != null) {
						queue.offer(pop.left);
						queue.offer(pop.right);
					}
				}
			}
		}

		return "[" + sb.substring(0, sb.length() - 1) + "]";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("[]") || data == null)
			return null;

		String tree = data.substring(1, data.length() - 1);
		String[] nodes = tree.split(",");
		int i = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = parseNode(nodes[0]);
		queue.add(root);
		while (!queue.isEmpty() && i < nodes.length) {
			TreeNode pop = queue.poll();
			if (pop == null) {
				continue;
			}
			pop.left = parseNode(nodes[i++]);
			queue.offer(pop.left);
			if (i < nodes.length) {
				pop.right = parseNode(nodes[i++]);
				queue.offer(pop.right);
			}
		}
		return root;
	}

	public TreeNode parseNode(String str) {
		return str.equals("null") ? null : new TreeNode(Integer.valueOf(str));
	}
}
