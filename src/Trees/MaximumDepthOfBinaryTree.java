package Trees;
//Given the root of a binary tree, return its depth.
//
//The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Example 1:
//
//
//
//Input: root = [1,2,3,null,null,4]
//
//Output: 3
//Example 2:
//
//Input: root = []
//
//Output: 0
public class MaximumDepthOfBinaryTree {
	 public int maxDepth(TreeNode root) {
		  if(root == null) {
			   return 0; 
		  }
		  
		 int  lh = maxDepth(root.left ); 
		  int rh = maxDepth (root.right); 
		  
		  return Math.max(lh, rh)+1; 
	    }
}
