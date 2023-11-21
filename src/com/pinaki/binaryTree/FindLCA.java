package com.pinaki.binaryTree;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class FindLCA {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);

		TreeNode lca = lowestCommonAncestor(root, root.left, root.right);
		System.out.println("The lowest Common Ancestor Of Binary Tree of the Binary Tree is : " + lca.val);

	}

	/*
	 * Time complexity: O(N) where n is the number of nodes.
	 * 
	 * Space complexity: O(N), auxiliary space.
	 */
}
