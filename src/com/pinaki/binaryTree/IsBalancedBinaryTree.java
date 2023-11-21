package com.pinaki.binaryTree;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class IsBalancedBinaryTree {
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return dfsHeight(root) != -1;
	}

	static int dfsHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);

		boolean isBalanced = isBalanced(root);
		System.out.println("Is the Binary Tree Height Balanced ? : " + isBalanced);

	}
}
