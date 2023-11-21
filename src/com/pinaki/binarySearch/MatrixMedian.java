package com.pinaki.binarySearch;

public class MatrixMedian {
	/*
	 * 
	 * Problem Statement: Given a row-wise sorted matrix of size r*c, where r is no.
	 * of rows and c is no. of columns, find the median in the given matrix.
	 * 
	 * Assume – r*c is odd
	 * 
	 * Examples:
	 * 
	 * Example 1: Input: r = 3 , c = 3 { 1 4 9 } { 2 5 6 } { 3 8 7 }
	 * 
	 * Output: Median = 5
	 * 
	 * Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5
	 * 6 7 8 9 So, median = 5
	 * 
	 * Step 1: Find the minimum and maximum element in the given array. By just
	 * traversing the first column, we find the minimum element and by just
	 * traversing the last column, we find the maximum element.
	 * 
	 * Step 2: Now find the middle element of the array one by one and check in the
	 * matrix how many elements are present in the matrix.
	 * 
	 * Three cases can occur:-
	 * 
	 * If count == (r*c+1)/2 , so it may be the answer still we mark max as mid
	 * since we are not referring indices , we are referring the elements and 5
	 * elements can be smaller than 6 also and 7 also , so to confirm we mark max as
	 * mid. If count<(r*c+1)/2 , we mark min as mid+1 since curr element or elements
	 * before it cannot be the answer. If count>(r*c+1)/2 , we mark max as mid ,
	 * since elements after this can only be the answer now.
	 */

	public static void main(String args[]) {
		int row = 3, col = 3;
		int[][] arr = { { 1, 4, 9 }, { 2, 5, 6 }, { 3, 8, 7 } };
		System.out.println("The median of the row-wise sorted matrix is: " + findMedian(arr, row, col));

	}

	private static int findMedian(int[][] arr, int row, int col) {

		int low = 1, high = 1000000000;
		int n = row;
		int m = col;
		while (low <= high) {
			int mid = (low + high) >> 1;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				cnt += countSmallerThanMid(arr[i], mid, col);
			}
			if (cnt <= (n * m) / 2)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	private static int countSmallerThanMid(int[] matRow, int num, int col) {
		int low = 0, high = col - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (matRow[mid] <= num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;
	}
}
