package com.pinaki.arrayProlems.dp;

public class UniquePaths {

	public static void main(String[] args) {

		// matrix initialization
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int m = matrix.length;
		int n = matrix[0].length;

		System.out.println(uniquePathsDP(m, n));
		System.out.println(uniquePathsNCR(m, n));
	}

	public static int uniquePathsDP(int m, int n) {
		int dp[][] = new int[m][n];
		int k = helper(0, 0, m, n, dp);
		return k;
	}

	public static int helper(int r, int c, int m, int n, int dp[][]) {
		if (c >= n || r >= m) {
			return 0;
		}
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		if (r == m - 1 && c == n - 1) {
			return 1;
		}
		int cnt1 = helper(r + 1, c, m, n, dp);
		int cnt2 = helper(r, c + 1, m, n, dp);
		return dp[r][c] = cnt1 + cnt2;
	}

	/*
	 * 
	 * Since we need an m+n-2 number of steps to reach the end among those steps if
	 * we choose n-1 rightward direction or m-1 downward direction and calculate the
	 * combinations ( i.e : m+n-2Cn-1 or m+n-2Cm-1) we’ll get the total number of
	 * paths.
	 */

	public static int uniquePathsNCR(int m, int n) {
		int N = m + n - 2;
		int r = n - 1;
		long ans = 1;
		for (int i = 1; i <= r; i++) {
			ans = ans * (N - r + i) / i;
		}
		return (int) ans;
	}
}
