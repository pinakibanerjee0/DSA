package com.pinaki.arrayProlems;

import java.util.Arrays;

/*
Given the heights of N towers and a value of K, Either increase or decrease the height of every tower by K (only once) where K > 0. After modifications, the task is to minimize the difference between the heights of the longest and the shortest tower and output its difference.

Examples: 

Input: arr[] = {1, 15, 10}, k = 6
Output:  Maximum difference is 5.
Explanation: Change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5 (between 4 and 9). We can’t get a lower difference.

Input: arr[] = {1, 5, 15, 10}, k = 3   
Output: Maximum difference is 8, arr[] = {4, 8, 12, 7}

The idea for this is given below:

The idea is to increase the first i towers by k and decrease the rest tower by k after sorting the heights, 
then calculate the maximum height difference.
This can be achieved using sorting.

Illustration:

Given arr[] = {1, 15, 10}, n = 3, k = 6

Array after sorting => arr[] = {1, 10, 15}

Initially maxHeight = arr[n – 1] = 15
            minHeight = arr[0] = 1
            ans = maxHeight – minHeight = 15 – 1 = 14

At i = 1

minHeight = min(arr[0] + k, arr[i] – k) = min(1 + 6, 10 – 6) = 4
maxHeight = max(arr[i – 1] + k, arr[n – 1] – k) = max(1 + 6, 15 – 6) = 9
ans = min(ans, maxHeight – minHeight) = min(14, 9 – 4) = 5 => ans = 5
At i = 2

minHeight = min(arr[0] + k, arr[i] – k) = min(1 + 6, 15 – 6) = 7
maxHeight = max(arr[i – 1] + k, arr[n – 1] – k) = max(10 + 6, 15 – 6) = 16
ans = min(ans, maxHeight – minHeight) = min(5, 16 – 7) = 5 => ans = 5
Hence minimum difference is 5 

Note:- Consider where a[i] < K because the height of the tower can’t be negative so neglect that case.

Follow the steps below to solve the given problem:

Sort the array 
Try to make each height of the tower maximum by decreasing the height of all the towers to the right by k 
and increasing all the height of the towers to the left by k. 
Check whether the current index tower has the maximum height or not by comparing it with a[n]-k. 
If the tower’s height is greater than the a[n]-k then it’s the tallest tower available.
Similarly, find the shortest tower and minimize the difference between these two towers
*/
public class MinimizeTheMaximumDifferenceBetweenTheHeights {

	public static void main (String[] args) {
		int[] arr = { 7, 4, 8, 8, 8, 9 };
		int k = 6;
		int ans = getMinDiff(arr, arr.length, k);
		System.out.println(ans);
	}

	// User function Template for Java
	public static int getMinDiff(int[] arr, int n, int k) {

		Arrays.sort(arr); //[4, 7, 8, 8, 8, 9]
		// Maximum possible height difference
		int ans = arr[n - 1] - arr[0];

		int tempmin, tempmax;
		tempmin = arr[0];
		tempmax = arr[n - 1];

		for (int i = 1; i < n; i++) {

			// if on subtracting k we got negative then
			// continue
			if (arr[i] - k < 0)
				continue;

			// Minimum element when we add k to whole array
			tempmin = Math.min(arr[0] + k, arr[i] - k);

			// Maximum element when we subtract k from whole
			// array
			tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);
			ans = Math.min(ans, tempmax - tempmin);
		}
		return ans;
	}
}
