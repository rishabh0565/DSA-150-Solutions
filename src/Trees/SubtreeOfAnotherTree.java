package Trees;

//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
//
//Example 1:
//
//
//
//Input: root = [1,2,3,4,5], subRoot = [2,4,5]
//
//Output: true
//Example 2:
//
//
//
//Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
//
//Output: false
public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (find(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

	}

	public boolean find(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return root == subRoot;
		}
		if (root.val != subRoot.val) {
			return false;
		}
		return find(root.left, subRoot.left) && find(root.right, subRoot.right);
	}
}
