package com.pinaki.arrayProlems.sorting;

public class HeapSort {

	// Heapify method to maintain heap property
	public void heapify(int[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left child index
		int r = 2 * i + 2; // right child index

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	// Main function to perform heapsort
	public void heapSort(int[] arr) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Call heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// Driver code to test HeapSort
	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		HeapSort hs = new HeapSort();
		hs.heapSort(arr);
		System.out.println("Sorted array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

/*
 * Time Complexity: O(n log n)
 * 
 * Space Complexity: O(1) (in place sorting algorithm)
 * 
 *
 */