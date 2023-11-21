package com.pinaki.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pinaki.binaryTree.InOrderTraversal.TreeNode;

public class LevelOrderTraversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> subLevels = new ArrayList<>();
			int levels = q.size();
			for (int i = 0; i < levels; i++) {
				TreeNode curr = q.poll();

				if (curr.left != null)
					q.offer(curr.left);
				if (curr.right != null)
					q.offer(curr.right);

				subLevels.add(curr.val);
			}
			ans.add(subLevels);
		}
		return ans;
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(6);

		List<List<Integer>> levelOrderTaversal = levelOrder(root);
		System.out.println("The level Order taversal of the Binary Tree is : " + levelOrderTaversal.toString());

	}

	/*
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(N)
	 */
}
