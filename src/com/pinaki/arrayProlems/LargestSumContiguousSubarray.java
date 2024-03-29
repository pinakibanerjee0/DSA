package com.pinaki.arrayProlems;

public class LargestSumContiguousSubarray {

	/*
	 * Kadane�s Algorithm can be viewed both as greedy and DP. As we can see that we
	 * are keeping a running sum of integers and when it becomes less than 0, we
	 * reset it to 0 (Greedy Part). This is because continuing with a negative sum
	 * is way worse than restarting with a new range. Now it can also be viewed as a
	 * DP, at each stage we have 2 choices: Either take the current element and
	 * continue with the previous sum OR restart a new range. Both choices are being
	 * taken care of in the implementation.
	 * 
	 * 
	 * kadane-algorithm The idea of Kadane�s algorithm is to maintain a variable
	 * max_ending_here that stores the maximum sum contiguous subarray ending at
	 * current index and a variable max_so_far stores the maximum sum of contiguous
	 * subarray found so far, Everytime there is a positive-sum value in
	 * max_ending_here compare it with max_so_far and update max_so_far if it is
	 * greater than max_so_far.
	 * 
	 * Pseudocode: Initialize: max_so_far = INT_MIN max_ending_here = 0
	 * 
	 * Loop for each element of the array
	 * 
	 * (a) max_ending_here = max_ending_here + a[i] (b) if(max_so_far <
	 * max_ending_here) max_so_far = max_ending_here (c) if(max_ending_here < 0)
	 * max_ending_here = 0 return max_so_far
	 * 
	 * Follow the below steps to Implement the idea:
	 * 
	 * Initialize the variables max_so_far = INT_MIN and max_ending_here = 0 Run a
	 * for loop from 0 to N-1 and for each index i: Add the arr[i] to
	 * max_ending_here. If max_so_far is less than max_ending_here then update
	 * max_so_far to max_ending_here. If max_ending_here < 0 then update
	 * max_ending_here = 0 Return max_so_far
	 */
	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = a.length;
		largestSumContiguousSubarray(a, n);
		//another approach
		largestSumContiguousSubarray(a);
	}

	static void largestSumContiguousSubarray(int a[], int size) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				start = i + 1;
			}
		}
		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
	}

	public static void largestSumContiguousSubarray(int[] arr) {
		int max_so_far = arr[0];
		int curr_max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			curr_max = Math.max(arr[i], curr_max + arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}

		System.out.println("Maximum contiguous sum is " + max_so_far);
	}

	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
}
