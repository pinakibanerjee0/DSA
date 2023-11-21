package com.pinaki.arrayProlems.matrix;

/*Problem Statement: Given an m*n 2D matrix and an integer, write a program to find if the given integer exists in the matrix.

Given matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row
Example 1:

Input: matrix = 
[[1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]], 

target = 3

Output: true

Explanation: As the given integer(target) exists in the given 2D matrix, the function has returned true.

*/
public class SearchInSorted2DMatrix {

	/*
	 * Intuition: As it is clearly mentioned that the given matrix will be row-wise
	 * and column-wise sorted, we can see that the elements in the matrix will be in
	 * a monotonically increasing order. So we can apply binary search to search the
	 * matrix. Consider the 2D matrix as a 1D matrix having indices from 0 to
	 * (m*n)-1 and apply binary search
	 */

	public static boolean searchMatrix(int[][] matrix, int target) {
		int lo = 0;
		if (matrix.length == 0)
			return false;
		int n = matrix.length;
		int m = matrix[0].length;
		int hi = (n * m) - 1;

		while (lo <= hi) {
			int mid = (lo + (hi - lo) / 2);
			if (matrix[mid / m][mid % m] == target) {
				return true;
			}
			if (matrix[mid / m][mid % m] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		// matrix initialization
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int m = matrix.length;
		int n = matrix[0].length;
		boolean isPresent = searchMatrix(matrix, 5);

		System.out.println(isPresent);
	}

	/*
	 * Time complexity: O(log(m*n))
	 * 
	 * Space complexity: O(1)
	 */
}
