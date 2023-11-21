package com.pinaki.arrayProlems.matrix;

public class TransposeOfAMatrix {
	/*
	 * Given a matrix, your task is to find its transpose of the given matrix.
	 * 
	 * Transpose: The transpose of a matrix means, interchanging its rows into
	 * columns or columns into rows.
	 * 
	 * Examples:
	 * 
	 * Example 1: Input: {{4,5,6}, 
	 * 					  {7,8,9}, 
	 * 					  {10,11,12}} 
	 * Output: 4 7 10 
	 * 		   5 8 11 
	 * 		   6 9 12
	 * 
	 * 
	 */
	/*
	Traverse through the entire matrix
	Swap row and corresponding column elements
	*/
	public static void main(String[] args) {

        //matrix initialization
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;

      transpose(matrix);

        //printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

	private static void transpose(int[][] matrix) {
		for(int i = 0 ; i<matrix.length ; i++) {
			for(int j = i ; j <matrix[i].length ; j++) {
				int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
			}
		}
		
	}
}

/*
 * 
 * Time complexity: O(n*m) for traversing
 * Space complexity: O(1)
*/
