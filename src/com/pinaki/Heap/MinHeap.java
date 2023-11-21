package com.pinaki.Heap;

import java.util.PriorityQueue;

public class MinHeap {

	/*
	 * 
	 * https://www.codingninjas.com/studio/problems/min-heap_4691801?topList=striver
	 * -sde-sheet-problems&utm_source=striver&utm_medium=website
	 * 
	 */

	public static void main(String[] args) {
		// Create a priority queue with initial capacity 10
		PriorityQueue<Integer> pq = new PriorityQueue<>(10, (a, b) -> (b- a));

		// Add elements to the queue
		pq.add(5);
		pq.add(4);
		pq.add(3);
		pq.add(1);
		pq.add(2);
		

		// Print the queue 
		System.out.println("Priority queue: " + pq.toString());

		// Peek at the top element of the queue
		System.out.println("Peek: " + pq.peek());

		// Remove the top element of the queue
		pq.poll();
		pq.poll();
		pq.poll();
		
		System.out.println("Peek: " + pq.peek());
		

		// Print the queue again
		System.out.println("Priority queue after removing top element: " + pq);
		
		

		// Check if the queue contains a specific element
		System.out.println("Does the queue contain 3? " + pq.contains(3));

		// Get the size of the queue
		System.out.println("Size of queue: " + pq.size());

		// Remove all elements from the queue
		pq.clear();

		// Check if the queue is empty
		System.out.println("Is the queue empty? " + pq.isEmpty());

	}

}
