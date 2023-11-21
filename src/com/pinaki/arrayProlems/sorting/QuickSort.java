package com.pinaki.arrayProlems.sorting;

public class QuickSort {

	/**
	 * This method sorts the input array using Quick Sort algorithm
	 * 
	 * @param arr
	 *            The input array to be sorted
	 * @param low
	 *            The starting index of the subarray to be sorted
	 * @param high
	 *            The ending index of the subarray to be sorted
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	/**
	 * This method partitions the input array using a pivot element
	 * 
	 * @param arr
	 *            The input array to be sorted
	 * @param low
	 *            The starting index of the subarray to be sorted
	 * @param high
	 *            The ending index of the subarray to be sorted
	 * @return The index of the pivot element after partitioning
	 */
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; 
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, ++i, high);

		return i;
	}

	/**
	 * This method swaps two elements of the input array
	 * 
	 * @param arr
	 *            The input array containing the elements to be swapped
	 * @param i
	 *            The index of the first element to be swapped
	 * @param j
	 *            The index of the second element to be swapped
	 */
	public static void swap(int[] arr, int i, int j) {
		if(i==j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int n = arr.length;

		quickSort(arr, 0, n - 1);

		System.out.println("Sorted array:");
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}
}

/*
 * Complexity Analysis:
 * 
 * Time Complexity: The time complexity of Quick Sort algorithm is O(n log n) in
 * the best and average case scenarios, and O(n^2) in the worst case scenario.
 * The recursive algorithm chooses a pivot element and partitions the array into
 * two subarrays, then recursively sorts each subarray until the array is fully
 * sorted. In the best and average case scenarios, the algorithm chooses a good
 * pivot that divides the array into subarrays of roughly equal size, leading to
 * O(n log n) time complexity. In the worst case scenario, the algorithm chooses
 * a bad pivot that causes one subarray to be significantly larger than the
 * other, leading to O(n^2) time complexity.
 * 
 * Space Complexity: The space complexity of Quick Sort algorithm is O(log n) in
 * the best and average case scenarios, and O(n) in the worst case scenario. The
 * recursive algorithm uses a stack to keep track of the subarrays being sorted,
 * which requires O(log n) space in the best and average case scenarios. In the
 * worst case scenario, the algorithm may create a deep recursion tree with n
 * levels, requiring O(n) space.
 */
