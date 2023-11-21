package com.pinaki.binaryTree;

class MaxPathSum {

	/*
	 * 
	 * To summarize:
	 * 
	 * Initialize a maxi variable to store our final answer. Do a simple tree
	 * traversal.
	 * 
	 * At each node, find recursively its leftMaxPath and its rightMaxPath.
	 * 
	 * Calculate the maxPath through the node as val + (leftMaxPath + rightMaxPath)
	 * and update maxi accordingly.
	 * 
	 * Return the maxPath when node is not the curving point as val +
	 * max(leftMaxPath, rightMaxPath).
	 */

	public static int maxPathSum(Node root) {
		int maxValue[] = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxPathDown(root, maxValue);
		return maxValue[0];
	}

	public static int maxPathDown(Node node, int maxValue[]) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left, maxValue));
		int right = Math.max(0, maxPathDown(node.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	static class Node {
		int val;
		Node left, right;

		Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public static void main(String args[]) {

		Node root = new Node(-10);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		int answer = maxPathSum(root);
		System.out.println("The Max Path Sum for this tree is " + answer);

	}
}