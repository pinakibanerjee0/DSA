package com.pinaki.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfs = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[V];
		vis[0] = true;
		q.offer(0);
		while (!q.isEmpty()) {
			int node = q.poll();
			bfs.add(node);

			for (Integer i : adj.get(node)) {
				if (!vis[i]) {
					vis[i] = true;
					q.offer(i);
				}
			}
		}

		return bfs;
	}

	public static void main(String args[]) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);

		Bfs sl = new Bfs();
		ArrayList<Integer> ans = sl.bfsOfGraph(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
