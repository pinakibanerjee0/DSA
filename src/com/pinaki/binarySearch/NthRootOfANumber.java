package com.pinaki.binarySearch;

public class NthRootOfANumber {

	/*
	 * 
	 * Problem Statement: Given two numbers N and M, find the Nth root of M.
	 * 
	 * The nth root of a number M is defined as a number X when raised to the power
	 * N equals M.
	 * 
	 * Example 1:
	 * 
	 * Input: N=3 M=27
	 * 
	 * Output: 3
	 * 
	 * Explanation: The cube root of 27 is 3.
	 */

	public static int getNthRoot(int n, int m) {
		int low = 1;
		int high = m;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (Math.pow(mid, n) == m) {
				return mid;
			} else if (Math.pow(mid, n) < m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 3, m = 27;
		System.out.println("The N'th root of the number " + m + " is : " + getNthRoot(n, m));
	}

}
