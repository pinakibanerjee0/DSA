package com.pinaki.arrayProlems.sorting;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped = false;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
	}

	private static void swap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort(arr);
		System.out.println("Sorted array:");
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
	}
}
/*
 * The time complexity of bubble sort is O(n^2) in the worst case and the space
 * complexity is O(1). The outer loop runs n-1 times, and the inner loop runs
 * n-i-1 times for each iteration of the outer loop. Therefore, the total number
 * of comparisons and swaps is (n-1) + (n-2) + ... + 1, which is equal to
 * n*(n-1)/2. This gives us O(n^2) time complexity. In the best case scenario,
 * if the array is already sorted, the algorithm will only make n-1 comparisons
 * and no swaps, which results in a time complexity of O(n). However, the worst
 * case scenario occurs when the array is reverse sorted and requires the
 * maximum number of swaps and comparisons.
 */