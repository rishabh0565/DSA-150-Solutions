package Trees;
//Given a binary tree, return true if it is height-balanced and false otherwise.
//
//A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//Example 1:
//
//
//
//Input: root = [1,2,3,null,null,4]
//
//Output: true
//Example 2:
//
//
//
//Input: root = [1,2,3,null,null,4,null,5]
//
//Output: false
//Example 3:
//
//Input: root = []
//
//Output: true
public class BalancedBinaryTree {
	  public boolean isBalanced(TreeNode root) {
          return check(root)!=-1 ; 
    } 
    public int check(TreeNode root){
         if(root == null) return 0 ; 
         int lh = check(root.left);
         if(lh==-1) return -1; 
         int rh = check(root.right);
         if(rh == -1) return -1 ;  
         if(Math.abs(lh - rh ) > 1) return -1; 
         return Math.max(lh,rh) + 1; 
    }
}
