package com.pinaki.arrayProlems.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int n = arr.length;

		bubbleSort(arr);

		System.out.println("Sorted array:");
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			boolean swap = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
					swap = true;
				}
			}
			if (!swap)
				break;
		}

	}

	private static void swap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

	private static void insertionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int key = arr[i], j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

	}

	private static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			int pivot = findPivot(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}

	}

	private static int findPivot(int[] arr, int low, int high) {
		int pivot = arr[high], i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, ++i, high);
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}

	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int leftArrSize = mid - low + 1;
		int rightArrSize = high - mid;
		int[] leftArr = new int[leftArrSize];
		int[] rightArr = new int[rightArrSize];

		for (int i = 0; i < leftArrSize; i++) {
			leftArr[i] = arr[low + i];
		}
		for (int i = 0; i < rightArrSize; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = low;

		while (i < leftArrSize && j < leftArrSize) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}

		while (i < leftArrSize) {
			arr[k++] = leftArr[i++];
		}

		while (j < rightArrSize) {
			arr[k++] = rightArr[j++];
		}

	}

}
