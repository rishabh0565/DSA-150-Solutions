package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.
//
//Example 1:
//
//
//
//Input: root = [1,2,3,4,5,6,7]
//
//Output: [[1],[2,3],[4,5,6,7]]
//Example 2:
//
//Input: root = [1]
//
//Output: [[1]]
//Example 3:
//
//Input: root = []
//
//Output: []
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < queueSize; i++) {

				TreeNode pop = queue.poll();
				level.add(pop.val);
				if (pop.left != null) {
					queue.offer(pop.left);
				}
				if (pop.right != null) {
					queue.offer(pop.right);
				}

			}
			res.add(level);

		}

		return res;
	}
}
