package com.pinaki.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Dikstra {
	private int V;
	private List<List<iPair>> adj;

	Dikstra(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	void addEdge(int u, int v, int w) {
		adj.get(u).add(new iPair(v, w));
		adj.get(v).add(new iPair(u, w));
	}

	void shortestPath(int src) {
		PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
 
        pq.add(new iPair(src,0));
        dist[src] = 0;
 
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
 
            for (iPair v : adj.get(u)) {
                if (dist[v.vertex] > dist[u] + v.weight) {
                    dist[v.vertex] = dist[u] + v.weight;
                    pq.add(new iPair(v.vertex , dist[v.vertex]));
                }
            }
        }

		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	static class iPair {
		int vertex, weight;

		iPair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		int V = 4;
		Dikstra g = new Dikstra(V);

		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 20);
		g.addEdge(2, 3, 2);
		

		g.shortestPath(0);
	}
}
