package com.pinaki.binaryTree;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class Practice {
	
	static int prev = Integer.MIN_VALUE;
	public static void main(String args[]) {
	/*	Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		System.out.println("Efficient Approach");
		if (isBST(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");*/
		
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

	private static boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		return dfsHeight(root)!= -1;
	}

	private static int dfsHeight(TreeNode root) {
		if(root==null)
			return 0;
		int leftHeight = dfsHeight(root.left);
		if(leftHeight==-1) return -1;
		
		int rightHeight = dfsHeight(root.right);
		if(rightHeight==-1) return -1;

		if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		
		return Math.abs(leftHeight - rightHeight) + 1;
	}

	private static boolean isBST(Node root) {
		if(root == null) return true;
		
		if(!isBST(root.left)) return false;
		
		if(root.key<=prev) return false;
		
		prev= root.key;
		
		return isBST(root.right);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int x) {
			key = x;
			left = right = null;
		}
	}
}
