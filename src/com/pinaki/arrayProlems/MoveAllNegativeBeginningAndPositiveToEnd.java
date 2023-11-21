package com.pinaki.arrayProlems;

import java.util.Arrays;

public class MoveAllNegativeBeginningAndPositiveToEnd {

	// Naive approach: The idea is to sort the array of elements, this will make
	// sure that all the negative elements will come before all the positive
	// elements.

	// Time Complexity: O(n*log(n)), Where n is the length of the given array.
	// Auxiliary Space: O(1)

	public static void main(String args[]) {
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };

		// rearrange(arr, arr.length); // Time complexity: O(N) Auxiliary Space: O(1)

		/*
		 * Two Pointer Approach: The idea is to solve this problem with constant space
		 * and linear time is by using a two-pointer or two-variable approach where we
		 * simply take two variables like left and right which hold the 0 and N-1
		 * indexes. Just need to check that :
		 * 
		 * Check If the left and right pointer elements are negative then simply
		 * increment the left pointer. Otherwise, if the left element is positive and
		 * the right element is negative then simply swap the elements, and
		 * simultaneously increment and decrement the left and right pointers. Else if
		 * the left element is positive and the right element is also positive then
		 * simply decrement the right pointer. Repeat the above 3 steps until the left
		 * pointer <= right pointer.
		 * 
		 */

		shiftall(arr, 0, arr.length - 1);
		System.out.println("after movin elements the array is : " + Arrays.toString(arr));
	}

	/*
	 * 
	 * This is an in-place rearranging algorithm for arranging the positive and
	 * negative numbers where the order of elements is not maintained. Time
	 * Complexity: O(N) Auxiliary Space: O(1)
	 */
	static void shiftall(int[] arr, int left, int right) {

		// Loop to iterate over the
		// array from left to the right
		while (left <= right) {

			// Condition to check if the left
			// and the right elements are
			// negative
			if (arr[left] < 0 && arr[right] < 0)
				left++;

			// Condition to check if the left
			// pointer element is positive and
			// the right pointer element is negative
			else if (arr[left] > 0 && arr[right] < 0) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

			// Condition to check if both the
			// elements are positive
			else if (arr[left] > 0 && arr[right] > 0)
				right--;
			else // if (arr[left] < 0 && arr[right] > 0)
			{
				left++;
				right--;
			}
		}
	}

	static void rearrange(int arr[], int n) {
		int j = 0, temp;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

}
