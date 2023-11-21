package com.pinaki.arrayProlems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 *  Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 
 *  and then return the matrix.

Examples:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.
Therefore the 2nd column and 2nd row will be set to 0.
 * 
 * */
public class SetMatrixZeros {

	public static void setZeros(int matrix[][]) {

		/*
		 * Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no.
		 * of columns in the matrix. Reason: We are traversing the entire matrix 2 times
		 * and each traversal is taking O(N*M) time complexity.
		 * 
		 * Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M =
		 * no. of columns in the matrix.
		 */
		int m = matrix.length;
		if (m == 0) {
			return;
		}
		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows.contains(i) || columns.contains(j))
					matrix[i][j] = 0;
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

		int n = matrix.size();
		int m = matrix.get(0).size();

		int[][] matrix2 = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 } };

		setZeros(matrix2);

		ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

		System.out.println("The Final matrix is: ");
		for (ArrayList<Integer> row : ans) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Optimal Approach (without using any extra space):
	 * 
	 * Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no.
	 * of columns in the matrix. Reason: In this approach, we are also traversing
	 * the entire matrix 2 times and each traversal is taking O(N*M) time
	 * complexity.
	 * 
	 * Space Complexity: O(1) as we are not using any extra space
	 * 
	 */
	private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
		int col0 = 1;
		// step 1: Traverse the matrix and
		// mark 1st row & col accordingly:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix.get(i).get(j) == 0) {
					// mark i-th row:
					matrix.get(i).set(0, 0);

					// mark j-th column:
					if (j != 0)
						matrix.get(0).set(j, 0);
					else
						col0 = 0;
				}
			}
		}

		// Step 2: Mark with 0 from (1,1) to (n-1, m-1):
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix.get(i).get(j) != 0) {
					// check for col & row:
					if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
						matrix.get(i).set(j, 0);
					}
				}
			}
		}

		// step 3: Finally mark the 1st col & then 1st row:
		if (matrix.get(0).get(0) == 0) {
			for (int j = 0; j < m; j++) {
				matrix.get(0).set(j, 0);
			}
		}
		if (col0 == 0) {
			for (int i = 0; i < n; i++) {
				matrix.get(i).set(0, 0);
			}
		}

		return matrix;
	}
}
