package com.pinaki.binaryTree;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeiht = maxDepth(root.right);

        return 1 + Math.max(leftHeight,rightHeiht);
    }
	
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);

		int MaximumDepthOfBinaryTree = maxDepth(root);
		System.out.println("The Maximum Depth Of Binary Tree of the Binary Tree is : " + MaximumDepthOfBinaryTree);

	}
}
