package com.pinaki.arrayProlems.sorting;

public class SelectionSort {

	/**
	 * This method sorts the input array using Selection Sort algorithm
	 * 
	 * @param arr
	 *            The input array to be sorted
	 */
	public static void selectionSort(int[] arr) {
		int n = arr.length;

		// Iterate through the array and select the minimum element
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// Swap the minimum element with the first element of the unsorted part
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		selectionSort(arr);
		System.out.println("Sorted array:");
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
	}
}
/*
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: The time complexity of Selection Sort algorithm is O(n^2) in
 * the worst, best, and average case scenarios. In the worst case, where the
 * array is in reverse order, the algorithm will make n(n-1)/2 comparisons and
 * n-1 swaps, leading to O(n^2) time complexity. In the best case scenario,
 * where the array is already sorted, the algorithm will make n(n-1)/2
 * comparisons and no swaps, which still results in a time complexity of O(n^2).
 * In the average case, the number of comparisons and swaps will be somewhere
 * between the best and worst cases, giving an average time complexity of
 * O(n^2).
 * 
 * Space Complexity: 
 * 
 * The space complexity of Selection Sort algorithm is O(1)
 * since the sorting is done in-place and the algorithm doesn't require any
 * extra space.
 */