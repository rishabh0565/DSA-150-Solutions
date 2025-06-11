package Trees;
//You are given the root of a binary tree root. Invert the binary tree and return its root.

//
//Example 1:
//
//
//
//Input: root = [1,2,3,4,5,6,7]
//
//Output: [1,3,2,7,6,5,4]
//Example 2:
//
//
//
//Input: root = [3,2,1]
//
//Output: [3,1,2]
//Example 3:
//
//Input: root = []
//
//Output: []
//Constraints:
//
//0 <= The number of nodes in the tree <= 100.
//-100 <= Node.val <= 100

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode pop = queue.poll();
			TreeNode temp = pop.left;
			pop.left = pop.right;
			pop.right = temp;
			if (pop.left != null) {
				queue.offer(pop.left);
			}
			if (pop.right != null) {
				queue.offer(pop.right);
			}
		}
		return root;
	}

}
