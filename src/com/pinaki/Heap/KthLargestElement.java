package com.pinaki.Heap;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		PriorityQueue<Integer> pq;
		boolean minHeap = true;
		if (n - k > k) {
			pq = new PriorityQueue<>(n, (a, b) -> (b - a)); // max Heap
			minHeap = false;
		} else
			pq = new PriorityQueue<>(n); // min Heap

		for (int i : nums) {
			pq.add(i);
		}
		if (minHeap)
			k = n - k;
		/*else
			k--;*/
		while (--k > 0) {
			pq.poll();
		}

		return pq.poll();
	}

	public static void main(String[] args) {
		
		int [] nums = {3,2,1,5,6,4}; int k = 2;
		System.out.println("KthLargestElement is : "+findKthLargest( nums, k));

	}

}
