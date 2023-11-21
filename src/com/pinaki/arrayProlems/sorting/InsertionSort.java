package com.pinaki.arrayProlems.sorting;

public class InsertionSort {

	/**
	 * This method sorts the input array using Insertion Sort algorithm
	 * 
	 * @param arr
	 *            The input array to be sorted
	 */
	public static void insertionSort(int[] arr) {
		int n = arr.length;

		// Iterate through the unsorted part of the array
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Move elements greater than key to one position ahead
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			// Insert the key at its correct position
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		insertionSort(arr);
		System.out.println("Sorted array:");
 		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
	}
}

/*
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: The time complexity of Insertion Sort algorithm is O(n^2) in
 * the worst case scenario. In the worst case, where the array is in reverse
 * order, the algorithm will make n-1 comparisons and 1+2+...+(n-1) = n(n-1)/2
 * swaps, leading to O(n^2) time complexity. In the best case scenario, where
 * the array is already sorted, the algorithm will make n-1 comparisons and no
 * swaps, which results in a time complexity of O(n). In the average case, the
 * number of comparisons and swaps will be somewhere between the best and worst
 * cases, giving an average time complexity of O(n^2).
 * 
 * Space Complexity:
 * 
 * The space complexity of Insertion Sort algorithm is O(1) since the sorting is
 * done in-place and the algorithm doesn't require any extra space.
 * 
 * 
 * It's worth noting that Insertion sort is not the most efficient sorting
 * algorithm in terms of time complexity for large datasets. However, it
 * performs better than other algorithms like Selection sort, especially for
 * small or nearly sorted datasets.
 */
