package com.pinaki.arrayProlems;

import java.util.Arrays;

/*
Example:
Input:  arr[] = {1, 2, 3, 4, 5}
Output: arr[] = {5, 1, 2, 3, 4}

Following are steps. 
1) Store last element in a variable say x. 
2) Shift all elements one position ahead. 
3) Replace first element of array with x.

Time Complexity: O(n), as we need to iterate through all the elements. Where n is the number of elements in the array.
Auxiliary Space: O(1), as we are using constant space.
*/
public class CyclicallyRotateAnArrayByOne {

	static int arr[] = new int[] { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));

		rotate();

		System.out.println("Rotated Array is");
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate() {
		int n = arr.length;

		int x = arr[n - 1];

		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = x;

	}

	// Time Complexity: O(n), as we need to iterate through all the elements. Where
	// n is the number of elements in the array.
	// Auxiliary Space: O(1), as we are using constant space.
	static void rotateUsingTwoPointer() {
		int i = 0, j = arr.length - 1;
		while (i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
		}
	}
}
