package com.pinaki.Heap;

import java.util.PriorityQueue;

public class MedianDataStream {

	public static void main(String[] args) {
		MedianFinder median = new MedianFinder();
		median.addNum(1);
		median.addNum(2);
		median.addNum(3);
		median.addNum(4);

		System.out.println("median is : "+median.findMedian());
	}

	static class MedianFinder {
		PriorityQueue<Integer> maxHeap;
		PriorityQueue<Integer> minHeap;

		public MedianFinder() {
			maxHeap = new PriorityQueue<>((a, b) -> b - a);
			minHeap = new PriorityQueue<>();
		}

		public void addNum(int num) {
			if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			balance();
		}

		public double findMedian() {
			if (maxHeap.size() > minHeap.size()) {
				return 1.0 * maxHeap.peek();
			} else if (minHeap.size() > maxHeap.size()) {
				return 1.0 * minHeap.peek();
			} else {
				return (minHeap.peek() * 1.0 + maxHeap.peek() * 1.0) / (1.0 * 2);
			}
		}

		public void balance() {
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			} else if (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			}
		}
	}

}
