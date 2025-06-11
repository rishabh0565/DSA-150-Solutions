package Trees;

//Diameter of Binary Tree
//Solved 
//The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.
//
//The length of a path between two nodes in a binary tree is the number of edges between the nodes.
//
//Given the root of a binary tree root, return the diameter of the tree.
//
//Example 1:
//
//
//
//Input: root = [1,null,2,3,4,5]
//
//Output: 3
//Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].
//
//Example 2:
//
//Input: root = [1,2,3]
//
//Output: 2
public class DaimeterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {
		int[] max = new int[0];
		find(root, max);
		return max[0];
	}

	public int find(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int lh = find(root.left, max);
		int rh = find(root.right, max);

		int pathLength = lh + rh + 1;
		max[0] = Math.max(max[0], pathLength);
		return Math.max(lh, rh) + 1;
	}

}
