package com.pinaki.arrayProlems;

import java.util.Arrays;

/*
 * 
 * 
 * 
 * 
 * Sort an array of 0s, 1s and 2s | Dutch National Flag problem

Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write a function that sorts the given array.
 The functions should put all 0s first, then all 1s and all 2s in last.

This problem is also the same as the famous “Dutch National Flag problem”.
The problem was proposed by Edsger Dijkstra. The problem is as follows:

Given N balls of colour red, white or blue arranged in a line in random order. 
You have to arrange all the balls such that the balls with the same colours are adjacent with the order of the balls, 
with the order of the colours being red, white and blue 
(i.e., all red coloured balls come first then the white coloured balls and then the blue coloured balls). 

Example:
Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

ALGO:
Sort an array of 0s, 1s, and 2s using the Pointer Approach: 
This approach is based on the following idea:

The problem is similar to “Segregate 0s and 1s in an array”.
The problem was posed with three colors, here 0 , 1, 2. The array is divided into four sections: 
arr[1] to arr[low – 1]
arr[low] to arr[mid – 1]
arr[mid] to arr[high – 1]
arr[high] to arr[n]
If the ith element is 0 then swap the element to the low range.
Similarly, if the element is 1 then keep it as it is.
If the element is 2 then swap it with an element in high range.


Follow the steps below to solve the given problem:

Keep three indices low = 1, mid = 1, and high = N and 

there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) 
and high to N (the range containing 2).

Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high – 1 and update i = i – 1. 
As the swapped element is not processed
Print the array.
*
*
*
*
*
*/

public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int arr[] = { 2, 2, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		// sort012(arr, arr_size);
		sort012usingcount(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort012usingcount(int[] arr) {
		int c0 = 0, c1 = 0, c2 = 0, n = 0;

		for (int i : arr) {
			switch (i) {
			case 0:
				c0++;
				break;
			case 1:
				c1++;
				break;
			case 2:
				c2++;
				break;
			}
		}

		while (c0-- > 0) {
			arr[n++] = 0;
		}
		while (c1-- > 0) {
			arr[n++] = 1;
		}
		while (c2-- > 0) {
			arr[n++] = 2;
		}

	}
	/*
	 * Time Complexity: O(n), Only non nested traversals of the array are needed.
	 * 
	 * Space Complexity: O(1)
	 */

	// Sort the input array, the array is assumed to
	// have values in {0, 1, 2}
	static void sort012(int a[], int arr_size) {
		int lo = 0, mid = 0;
		int hi = arr_size - 1;
		// Iterate till all the elements
		while (mid <= hi) {
			switch (a[mid]) {
			// If the mid element is 0
			case 0: {
				swap(a, lo, mid);
				lo++;
				mid++;
				break;
			}
			// If the mid element is 1
			case 1:
				mid++;
				break;
			// If the mid element is 2
			case 2: {
				swap(a, mid, hi);
				hi--;
				break;
			}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	/*
	 * Approach 2 :Sort an array of 0s, 1s, and 2s using Counting Approach: This
	 * approach is based on the following idea:
	 * 
	 * Count the number of 0s, 1s, and 2s in the given array. Then store all the 0s
	 * at the beginning followed by all the 1s and then all the 2s.
	 * 
	 * Follow the steps below to solve the given problem:
	 * 
	 * Keep three counters c0 to count 0s, c1 to count 1s, and c2 to count 2s
	 * Traverse through the array and increase the count of c0 if the element is 0,
	 * increase the count of c1 if the element is 1 and increase the count of c2 if
	 * the element is 2 Now again traverse the array and replace the first c0
	 * elements with 0, the next c1 elements with 1, and the next c2 elements with
	 * 2.
	 */

}
