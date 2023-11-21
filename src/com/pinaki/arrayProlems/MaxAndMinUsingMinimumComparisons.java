package com.pinaki.arrayProlems;
/*
PROBLEM : Maximum and minimum of an array using minimum number of comparisons:
Examples:
Input: arr[] = {3, 5, 4, 1, 9}
Output: Minimum element is: 1
        Maximum element is: 9
*/

//how do we return multiple values from a function? We can do it either using structures or pointers. 
//We have created a structure named pair (which contains min and max) to return multiple values.

public class MaxAndMinUsingMinimumComparisons {

	static class Pair {

		int min;
		int max;
	}

	public static void main(String args[]) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		int arr_size = 6;
		// Pair minmax = getMinMaxUsingTournamentMethod(arr, 0, arr_size - 1);
		Pair minmax = getMinMax(arr, arr_size);
		System.out.printf("\nMinimum element is %d", minmax.min);
		System.out.printf("\nMaximum element is %d", minmax.max);

	}

	private static Pair getMinMax(int[] arr, int n) {
		Pair minmax = new Pair();
		int i;
		/*
		 * If array has even number of elements then initialize the first two elements
		 * as minimum and maximum
		 */
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				minmax.max = arr[0];
				minmax.min = arr[1];
			} else {
				minmax.min = arr[0];
				minmax.max = arr[1];
			}
			i = 2;
			/* set the starting index for loop */
		} /*
			 * If array has odd number of elements then initialize the first element as
			 * minimum and maximum
			 */ else {
			minmax.min = arr[0];
			minmax.max = arr[0];
			i = 1;
			/* set the starting index for loop */
		}

		/*
		 * In the while loop, pick elements in pair and compare the pair with max and
		 * min so far
		 */
		while (i < n - 1) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > minmax.max) {
					minmax.max = arr[i];
				}
				if (arr[i + 1] < minmax.min) {
					minmax.min = arr[i + 1];
				}
			} else {
				if (arr[i + 1] > minmax.max) {
					minmax.max = arr[i + 1];
				}
				if (arr[i] < minmax.min) {
					minmax.min = arr[i];
				}
			}
			i += 2;
			/*
			 * Increment the index by 2 as two elements are processed in loop
			 */
		}
		return minmax;

	}
	/*
	 * Time Complexity: O(n) Auxiliary Space: O(1) as no extra space was needed.
	 */
	// Approach 2: Maximum and minimum of an array using the tournament method:
	/*
	 * Divide the array into two parts and compare the maximums and minimums of the
	 * two parts to get the maximum and the minimum of the whole array. Pair
	 * MaxMin(array, array_size) if array_size = 1 return element as both max and
	 * min else if arry_size = 2 one comparison to determine max and min return that
	 * pair else // array_size > 2 recur for max and min of left half recur for max
	 * and min of right half one comparison determines true max of the two
	 * candidates one comparison determines true min of the two candidates return
	 * the pair of max and min
	 * 
	 * //Time Complexity: O(n) //Auxiliary Space: O(log n) as the stack space will
	 * be filled for the maximum height of the tree formed during recursive calls
	 * same as a binary tree. /* Total number of comparisons: let the number of
	 * comparisons be T(n). T(n) can be written as follows: Algorithmic Paradigm:
	 * Divide and Conquer
	 * 
	 * T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2 T(2) = 1 T(1) = 0 If n is a power of
	 * 2, then we can write T(n) as:
	 * 
	 * T(n) = 2T(n/2) + 2
	 * 
	 * After solving the above recursion, we get
	 * 
	 * T(n) = 3n/2 -2
	 * 
	 * Thus, the approach does 3n/2 -2 comparisons if n is a power of 2. And it does
	 * more than 3n/2 -2 comparisons if n is not a power of 2.
	 */

	private static Pair getMinMaxUsingTournamentMethod(int[] arr, int s, int e) {
		Pair minmax = new Pair();
		Pair leftMinmax = new Pair();
		Pair rightMinmax = new Pair();

		if (s == e) {
			minmax.max = arr[s];
			minmax.min = arr[s];
			return minmax;
		} else if (e == s + 1) {
			if (arr[s] > arr[e]) {
				minmax.max = arr[s];
				minmax.min = arr[e];
			} else {
				minmax.min = arr[s];
				minmax.max = arr[e];
			}
			return minmax;
		}
		int mid = s + (e - s) / 2;
		leftMinmax = getMinMaxUsingTournamentMethod(arr, s, mid - 1);
		rightMinmax = getMinMaxUsingTournamentMethod(arr, mid, e);

		if (leftMinmax.min < rightMinmax.min) {
			minmax.min = leftMinmax.min;
		} else {
			minmax.min = rightMinmax.min;
		}

		if (leftMinmax.max > rightMinmax.max) {
			minmax.max = leftMinmax.max;
		} else {
			minmax.max = rightMinmax.max;
		}

		return minmax;
	}
}
