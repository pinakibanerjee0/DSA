package com.pinaki.graph;

import java.util.Iterator;
import java.util.LinkedList;

class Bridges {
	private int V;

	private LinkedList<Integer> adj[];
	int time = 0;
	static final int NIL = -1;

	Bridges(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {

		visited[u] = true;

		disc[u] = low[u] = ++time;

		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next();

			if (!visited[v]) {
				parent[v] = u;
				bridgeUtil(v, visited, disc, low, parent);

				low[u] = Math.min(low[u], low[v]);

				if (low[v] > disc[u])
					System.out.println(u + " " + v);
			}

			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	void bridge() {
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];

		for (int i = 0; i < V; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
	}

	public static void main(String args[]) {
		System.out.println("Bridges in first graph ");
		Bridges g = new Bridges(6);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 3);
		g.bridge();
	}

}