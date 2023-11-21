package com.pinaki.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

class MaximumWidthofBinaryTree {

	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int ans = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			int curMin = q.peek().num; 
			int first = 0, last = 0;
			for (int i = 0; i < size; i++) {
				int root_Ind = q.peek().num - curMin;
				TreeNode node = q.peek().node;
				q.poll();
				if (i == 0)
					first = root_Ind;
				if (i == size - 1)
					last = root_Ind;
				if (node.left != null)
					q.offer(new Pair(node.left, root_Ind * 2 + 1));
				if (node.right != null)
					q.offer(new Pair(node.right, root_Ind * 2 + 2));
			}
			ans = Math.max(ans, last - first + 1);
		}
		return ans;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(6);

		int maxWidth = widthOfBinaryTree(root);
		System.out.println("The maximum width of the Binary Tree is : " + maxWidth);

	}

	private static class Pair {
		TreeNode node;
		int num;

		Pair(TreeNode _node, int _num) {
			num = _num;
			node = _node;
		}
	}
}