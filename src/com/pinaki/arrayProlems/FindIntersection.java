package com.pinaki.arrayProlems;

import java.util.Arrays;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 3, 3, 4, 5, 5, 6 };
		int[] b = { 3, 3, 5 };

		// Function call
		findIntersection(a, b);
	}

	public static void findIntersection(int[] arr1, int[] arr2) {
		// Sort both arrays in non-decreasing order
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		// Initialize variables to track indices of arr1 and arr2
		int i = 0;
		int j = 0;

		// Loop through both arrays to find intersection elements
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				// Found an intersection element, print it
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				// Increment index of arr1
				i++;
			} else {
				// Increment index of arr2
				j++;
			}
		}
	}

}
