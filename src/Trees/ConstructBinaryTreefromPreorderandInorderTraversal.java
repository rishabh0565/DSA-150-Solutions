package Trees;

import java.util.Arrays;

//You are given two integer arrays preorder and inorder.

//
//preorder is the preorder traversal of a binary tree
//inorder is the inorder traversal of the same tree
//Both arrays are of the same size and consist of unique values.
//Rebuild the binary tree from the preorder and inorder traversals and return its root.
//
//Example 1:
//
//
//
//Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
//
//Output: [1,2,3,null,null,null,4]
//Example 2:
//
//Input: preorder = [1], inorder = [1]
//
//Output: [1]

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	int inIdx = 0;
	int preIdx = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		System.out.println("preOrder" + Arrays.toString(preorder));
		System.out.println("inOder" + Arrays.toString(inorder));
		return createBT(preorder, inorder, Integer.MAX_VALUE);
	}

//	public TreeNode createBT(int[] preorder, int[] inorder, int currentNodeVal) {
//		if (pdx >= preorder.length)
//			return null;
//		if (inorder[idx] == currentNodeVal) {
//			idx++;
//			return null;
//		}
//
//		TreeNode node = new TreeNode(preorder[pdx++]);
//		node.left = createBT(preorder, inorder, node.val);
//		node.right = createBT(preorder, inorder, currentNodeVal);
//		return node;
//	}

	public TreeNode createBT(int[] preorder, int[] inorder, int stopVal) {
		if (preIdx >= preorder.length) {
			System.out.println("preIdx " + preIdx + " out of bounds, returning null");
			return null;
		}

		if (inorder[inIdx] == stopVal) {
			System.out.println("Stopping at inorder[" + inIdx + "] = " + inorder[inIdx] + " == stopVal " + stopVal);
			inIdx++;
			return null;
		}

		int rootVal = preorder[preIdx];
		TreeNode root = new TreeNode(rootVal);
		System.out.println("Created Node: " + rootVal + " (preIdx = " + preIdx + ", inIdx = " + inIdx + ", stopVal = "
				+ stopVal + ")");
		preIdx++;

		System.out.println("Creating LEFT subtree of " + rootVal + " with stopVal = " + rootVal);
		root.left = createBT(preorder, inorder, rootVal);

		System.out.println("Creating RIGHT subtree of " + rootVal + " with stopVal = " + stopVal);
		root.right = createBT(preorder, inorder, stopVal);

		return root;
	}
}
