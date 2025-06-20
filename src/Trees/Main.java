package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		TreeNode child1 = new TreeNode(1);
//		TreeNode child2 = new TreeNode(5);
//		root.left = child1;
//		root.right = child2;
//
//		TreeNode child3 = new TreeNode(-1);
//		TreeNode child4 = new TreeNode(2);
//
//		child1.left = child3;
//		child1.right = child4;
//
//		TreeNode child5 = new TreeNode(7);
//		child2.right = child5;

		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		TreeNode child11 = new TreeNode(4);
		TreeNode child22 = new TreeNode(5);
		root.left = child1;
		root.right = child2;
		child2.left = child11;
		child2.right = child22;

//
		ConstructBinaryTreefromPreorderandInorderTraversal cbtfpaiot = new ConstructBinaryTreefromPreorderandInorderTraversal();
		inOrderDisplay(cbtfpaiot.buildTree(new int[] { 1, 2, 3, 4 }, new int[] { 2, 1, 3, 4 }));

//		SerializeAndDeserializeBinaryTree sadbt = new SerializeAndDeserializeBinaryTree();
//		String serailizedTree = sadbt.serialize(root);
//		System.out.println(serailizedTree);
//		TreeNode deserialize = sadbt.deserialize(serailizedTree);
//		levelByLevel(deserialize);
	}

	// 3
	// 1 5
//  -1   2  "   7

	public static void getKSmallestInBST(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		getKSmallestInBST(root.left, list);
		list.add(root.val);
		getKSmallestInBST(root.right, list);
	}

	public static void find(ArrayList<Integer> list, int k) {
		if (k == 0) {
			System.out.println(0);
		}
		System.out.println(list.get(k - 1));
	}

	public static void preOrTr(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrTr(root.left);
		preOrTr(root.right);

	}

	public static void postOrTr(TreeNode root) {
		if (root == null)
			return;
		postOrTr(root.left);
		postOrTr(root.right);
		System.out.print(root.val + " ");

	}

	public static int maximumPath(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int lsum = Math.max(0, maximumPath(root.left, max));
		int rsum = Math.max(0, maximumPath(root.right, max));

		int currentSum = root.val + lsum + rsum;
		max[0] = Math.max(max[0], currentSum);

		return root.val + Math.max(rsum, lsum);

	}

	public static int getMaxDiameter(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int lh = 0;
		int rh = 0;
		lh = getMaxDiameter(root.left, max);
		rh = getMaxDiameter(root.right, max);

		max[0] = Math.max(max[0], rh + lh);
		return Math.max(rh, lh) + 1;

	}

	public static int isBalancedTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = 0;
		int rh = 0;

		lh = isBalancedTree(root.left);
		if (lh == -1)
			return -1;

		rh = isBalancedTree(root.right);
		if (rh == -1)
			return -1;

		if (rh - lh > 1)
			return -1;
		return Math.max(lh, rh) + 1;

	}

	public static void iterativeInOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return;
		}
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
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
		if (root == null) {
			return;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode pop = stack.pop();
			System.out.print(pop.val + " ");
			if (pop.right != null) {
				stack.push(pop.right);
			}
			if (pop.left != null) {
				stack.push(pop.left);
			}
		}
	}

	public static void levelByLevel(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				TreeNode current = queue.poll();
				System.out.print(current.val + " ");
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			System.out.println();
		}

	}

	public static void inOrderDisplay(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrderDisplay(root.left);
		System.out.print(root.val + " ");
		inOrderDisplay(root.right);
	}

	public static void preOrderDisplay(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		inOrderDisplay(root.left);
		inOrderDisplay(root.right);

	}

	public static void postOrderDisplay(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderDisplay(root.left);
		inOrderDisplay(root.right);
		System.out.print(root.val + " ");

	}
}
