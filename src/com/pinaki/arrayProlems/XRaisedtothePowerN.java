package com.pinaki.arrayProlems;

/*Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).

Examples:

Example 1:

Input: x = 2.00000, n = 10

Output: 1024.00000

Explanation: You need to calculate 2.00000 raised to 10 which gives ans 1024.00000

Example 2:

Input: x = 2.10000, n = 3

Output: 9.26100

Explanation: You need to calculate 2.10000 raised to 3 which gives ans 9.26100*/
public class XRaisedtothePowerN {
	/*
	 * Time Complexity: O(N)
	 * 
	 * Space Complexity: O(1)
	 */
	public static double myPow(double x, int n) {
		double ans = 1.0;
		for (int i = 0; i < n; i++) {
			ans = ans * x;
		}
		return ans;
	}

	/*
	 * Using Binary Exponentiation
	 * 
	 * Approach: Initialize ans as 1.0 and store a duplicate copy of n i.e nn using
	 * to avoid overflow
	 * 
	 * Check if nn is a negative number, in that case, make it a positive number.
	 * 
	 * Keep on iterating until nn is greater than zero, now if nn is an odd power
	 * then multiply x with ans ans reduce nn by 1. Else multiply x with itself and
	 * divide nn by two.
	 * 
	 * Now after the entire binary exponentiation is complete and nn becomes zero,
	 * check if n is a negative value we know the answer will be 1 by and.
	 */
	public static double myPowBinaryExponential(double x, int n) {
		double ans = 1.0;
		long nn = n;
		if (nn < 0)
			nn = -1 * nn;
		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}
		if (n < 0)
			ans = (double) (1.0) / (double) (ans);
		return ans;
	}
	/*
	 * Time Complexity: O(log n)
	 * 
	 * Space Complexity: O(1)
	 */

	public static void main(String args[]) {
		System.out.println(myPow(2, 10));
		System.out.println(myPowBinaryExponential(2, 10));
	}
}
