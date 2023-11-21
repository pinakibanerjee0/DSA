package com.pinaki.arrayProlems.sorting;

public class MergeSort {

	/**
	 * This method sorts the input array using Merge Sort algorithm
	 * 
	 * @param arr
	 *            The input array to be sorted
	 * @param left
	 *            The index of the leftmost element of the subarray
	 * @param right
	 *            The index of the rightmost element of the subarray
	 */
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	/**
	 * This method merges the two subarrays of arr[]
	 * 
	 * @param arr
	 *            The input array to be sorted
	 * @param left
	 *            The index of the leftmost element of the subarray
	 * @param mid
	 *            The index of the middle element of the subarray
	 * @param right
	 *            The index of the rightmost element of the subarray
	 */
	public static void merge(int[] arr, int left, int mid, int right) {
		int leftArr_Size = mid - left + 1;
		int rightArr_Size = right - mid;

		int[] leftArr = new int[leftArr_Size];
		int[] rightArr = new int[rightArr_Size];

		// Copy data to temp arrays
		for (int i = 0; i < leftArr_Size; ++i) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < rightArr_Size; ++j) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		// Merge the two temp arrays back into arr[]
		while (i < leftArr_Size && j < rightArr_Size) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			//	i++;
			} else {
				arr[k++] = rightArr[j++];
			//	j++;
			}
			//k++;
		}

		// Copy remaining elements of leftArr[] if any
		while (i < leftArr_Size) {
			arr[k++] = leftArr[i++];
			//i++;
			//k++;
		}

		// Copy remaining elements of rightArr[] if any
		while (j < rightArr_Size) {
			arr[k++] = rightArr[j++];
			//j++;
		//	k++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int n = arr.length;

		mergeSort(arr, 0, n - 1);

		System.out.println("Sorted array:");
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}
}
/*
 * 
 * 
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: The time complexity of Merge Sort algorithm is O(n log n) in
 * the worst, best, and average case scenarios. The recursive algorithm divides
 * the array into two halves until each sub array has only one element, then
 * merges them back into the sorted order, which takes O(n log n) time in total.
 * 
 * Space Complexity: The space complexity of Merge Sort algorithm is O(n) since
 * the algorithm creates temporary arrays to hold the divided sub arrays.
 *
 *
 */