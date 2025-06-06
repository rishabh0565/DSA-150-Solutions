package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 TreeNode child1  = new TreeNode(2); 
		// TreeNode child2 = new TreeNode(null); 
		 root.left = child1; 
		// root.right = child2;
		 
//		 TreeNode child3 = new TreeNode(4); 
//		 TreeNode child4 = new TreeNode(5); 
//		 
//		 child1.left = child3; 
//		 child1.right = child4;
//		 
//		 TreeNode child5 = new TreeNode(6); 
//		 child2.right = child5; 
		//iterativeInOrder(root);
		InvertTree it = new InvertTree(); 
		TreeNode invertTree = it.invertTree(root);
       levelByLevel(invertTree);
	}
    
    //     1 
    //   2   3 
    //  4  5 " 6 
   
    public static void iterativeInOrder(TreeNode root) {
   	 Stack<TreeNode> stack = new Stack<>(); 
   	 if(root==null) {
   		 return; 
   	 }
   	 TreeNode current  = root;  
   	 while(current!=null || !stack.isEmpty()) {
   		   while(current!=null) {
   			   stack.push(current); 
   			   current = current.left; 
   		   }
   		   current = stack.pop();
   		   System.out.print(current.val + " ");
   		   
   		   current = current.right; 
   	 }
   }
    
    public static void iterativePreOrder(TreeNode root) {
    	 Stack<TreeNode> stack = new Stack<>(); 
    	 if(root==null) {
    		 return; 
    	 }
    	 stack.push(root); 
    	 while(!stack.isEmpty()) {
    		   TreeNode pop = stack.pop(); 
    		   System.out.print(pop.val+ " ");
    		   if(pop.right!=null) {
    			    stack.push(pop.right); 
    		   }
    		   if(pop.left!=null) {
    			   stack.push(pop.left); 
    		   }
    	 }
    }
    
    
    
    
    public static void levelByLevel(TreeNode root) {
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	if(root!=null) {
    		 queue.offer(root); 
    	}
    	while(!queue.isEmpty()) {
    		int level = queue.size(); 
    		for(int i = 0 ; i < level ; i++) {
    		TreeNode current = queue.poll(); 
    		  System.out.print(current.val+ " ");
    		 if(current.left!=null) {
    			 queue.offer(current.left); 
    		 }
    		 if(current.right!=null) {
    			 queue.offer(current.right); 
    		 }
    		}
    		System.out.println();
    	}
    	 
    }
    
 
    
    public static void inOrderDisplay(TreeNode root) {
    	 if(root == null) {
    		  return ; 
    	 } 
    	 
    	 inOrderDisplay(root.left);
    	 System.out.print( root.val +" " );
    	 inOrderDisplay(root.right);
    }
    
    public static void preOrderDisplay(TreeNode root) {
   	 if(root == null) {
   		  return ; 
   	 }
   	 System.out.print( root.val +" " );
	 inOrderDisplay(root.left);
   	 inOrderDisplay(root.right);
   	
   
   }
    
    public static void postOrderDisplay(TreeNode root) {
      	 if(root == null) {
      		  return ; 
      	 }
   	 inOrderDisplay(root.left);
      	 inOrderDisplay(root.right);
      	 System.out.print( root.val +" " );
      
      }
}
