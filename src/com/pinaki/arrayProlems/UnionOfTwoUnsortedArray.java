package com.pinaki.arrayProlems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionOfTwoUnsortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 5, 7, 3, 8 };
		int[] arr2 = { 9, 3, 5, 4, 1, 7 };

		unionUsingSetDS(arr1, arr2);
		optimizedUnionUsingSetDS(arr1, arr1.length, arr2, arr2.length);
		Union(arr1, arr2, arr1.length, arr2.length);
	}

	/*
	 * Method 1 (Using Set):
	 * 
	 * Union of two arrays we can get with the Set data structure very easily. A set
	 * is a data structure that allows only the distinct elements in it. So, when we
	 * put the elements of both the array into the set we will get only the distinct
	 * elements that are equal to the union operation over the arrays.
	 * 
	 * Time Complexity: O(m * log(m) + n * log(n)) Auxiliary Space: O(m + n)
	 */

	private static void unionUsingSetDS(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			set.add(arr2[i]);
		}

		System.out.println("Union of arrays: " + set);
	}

	// Time Complexity: O( max(m,n) ) Auxiliary Space: O(max(m, n))
	static void optimizedUnionUsingSetDS(int a[], int n, int b[], int m) {
		// find min of n and m
		int min = (n < m) ? n : m;

		// set container
		Set<Integer> set = new HashSet<>();

		// add elements from both the arrays for
		// index from 0 to min(n, m)-1
		for (int i = 0; i < min; i++) {
			set.add(a[i]);
			set.add(b[i]);
		}

		// add remiaining elements to the set from the other
		// array (having greater length)
		// note that only one of the loops will execute
		if (n > m) {
			for (int i = m; i < n; i++) {
				set.add(a[i]);
			}
		} else if (n < m) {
			for (int i = n; i < m; i++) {
				set.add(b[i]);
			}
		}

		// driver code to print the output
		System.out.println("Number of elements after union operation: " + set.size());
		System.out.println("The union set of both arrays is :");
		System.out.print(set.toString());
	}

	/*
	 * Method 2: (Using map data structure)
	 * 
	 * From the knowledge of data structures, we know that map stores distinct keys
	 * only. So if we insert any key appearing more than one time it gets stored
	 * only once. The idea is to insert both the arrays in one common map which
	 * would then store the distinct elements of both arrays (union of both the
	 * array).
	 * 
	 * Time Complexity: O(m * log(m) + n * log(n)), Auxiliary Space: O(m + n)
	 */

	static void printUnion(int[] a, int n, int[] b, int m) {
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		// Inserting array elements in mp
		for (int i = 0; i < n; i++) {
			mp.put(a[i], i);
		}
		for (int i = 0; i < m; i++) {
			mp.put(b[i], i);
		}

		System.out.println("The union set of both arrays is :");
		for (Map.Entry mapElement : mp.entrySet()) {
			System.out.println(mapElement.getKey() + " ");

			// mp will contain only distinct
			// elements from array a and b
		}
	}

	/*
	 * This implementation has a time complexity of O(nlogn) due to the sorting
	 * step, but it has a space complexity of O(1) because we are not using any
	 * extra space except for the result array.
	 */
	// Function to find union
	static void Union(int[] a, int[] b, int n, int m) {

		int[] result = new int[n + m];

		Arrays.sort(a);
		Arrays.sort(b);

		int index = 0;
		int left = 0, right = 0;
		while (left < n && right < m) {

			if (a[left] < b[right]) {
				if (index != 0 && a[left] == result[index - 1]) {
					left++;
				} else {
					result[index] = a[left];
					left++;
					index++;
				}
			} else {
				if (index != 0 && b[right] == result[index - 1]) {
					right++;
				} else {
					result[index] = b[right];
					right++;
					index++;
				}
			}
		}

		while (left < n) {
			if (index != 0 && a[left] == result[index - 1]) {
				left++;
			} else {
				result[index] = a[left];
				left++;
				index++;
			}
		}

		while (right < m) {
			if (index != 0 && b[right] == result[index - 1]) {
				right++;
			} else {
				result[index] = b[right];
				right++;
				index++;
			}
		}

		System.out.print("Union: ");
		for (int k = 0; k < index; k++)
			System.out.print(result[k] + " ");
		System.out.println("");
	}
}
