package Trees;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "" + this.val;
	}

}
