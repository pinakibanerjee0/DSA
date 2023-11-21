package com.pinaki.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        travarseInOrder(root,inOrder);
        return inOrder;
    }

    private static void travarseInOrder (TreeNode curr , List<Integer> inOrder){
        if(curr==null) return;

        travarseInOrder(curr.left,inOrder);
        inOrder.add(curr.val);
        travarseInOrder(curr.right,inOrder);
    }

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		/*
		 * Binary Tree :
		 * 				1
		 * 			2		3
		 * 		4		5 6		7
		 */
		TreeNode t = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		
		List<Integer> res = inorderTraversal(t);
		System.out.println("Inorder Traversal of Binary Tree t is: " + res.toString());
	}
}
