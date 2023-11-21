package com.pinaki.binaryTree;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class DiameterofBinaryTree {
	
	 public static int diameterOfBinaryTree(TreeNode root) {
	        int[] maxHeight = new int[1];
	        height(root,maxHeight);
	        return maxHeight[0];
	    }
	    public static int height(TreeNode root ,  int[]maxHeight){
	        if (root==null) return 0;
	        int leftHeiht = height(root.left,maxHeight);
	        int rightHeight = height(root.right,maxHeight);
	        maxHeight[0] = Math.max(maxHeight[0],leftHeiht+rightHeight);
	        return 1+Math.max(leftHeiht,rightHeight);
	    }

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);

		int diameterOfBinaryTree = diameterOfBinaryTree(root);
		System.out.println("The diameter Of Binary Tree of the Binary Tree is : " + diameterOfBinaryTree);

	}
}
