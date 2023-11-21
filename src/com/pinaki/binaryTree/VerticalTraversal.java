package com.pinaki.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.pinaki.binaryTree.TopAndbottomView.Node;
import com.pinaki.binaryTree.TopAndbottomView.Pair;

public class VerticalTraversal {
	public static void vTraversal(Node root) {
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (q.isEmpty() == false) {
			Pair p = q.poll();
			Node curr = p.node;
			int hd = p.hd;
			if (mp.containsKey(hd))
				mp.get(hd).add(curr.key);
			else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(curr.key);
				mp.put(hd, al);
			}
			if (curr.left != null)
				q.add(new Pair(curr.left, hd - 1));
			if (curr.right != null)
				q.add(new Pair(curr.right, hd + 1));
		}
		for (Map.Entry<Integer, ArrayList<Integer>> p : mp.entrySet()) {
			ArrayList<Integer> al = p.getValue();
			for (int x : al)
				System.out.print(x + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		vTraversal(root);
	}
}
