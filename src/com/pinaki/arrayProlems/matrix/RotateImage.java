package com.pinaki.arrayProlems.matrix;

public class RotateImage {
	/*
	 * Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
	 * 
	 * Note: Rotate matrix 90 degrees anti clockwise
	 * 
	 * Examples:
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,2,3],[4,5,6],[7,8,9]]
	 * 
	 * Output: [[7,4,1],[8,5,2],[9,6,3]]
	 * 
	 * By observation, we see that the first column of the original matrix is the
	 * reverse of the first row of the rotated matrix, so that’s why we transpose
	 * the matrix and then reverse each row, and since we are making changes in the
	 * matrix itself space complexity gets reduced to O(1).
	 */
	
	public static void main(String[] args) {

        //matrix initialization
        int matrix[][] =  {  {1,2,3}, {4,5,6}, {7,8,9}};
        int m = matrix.length;
        int n = matrix[0].length;

        transpose(matrix);
        reverseEachRow(matrix);

        //printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	private static void reverseEachRow(int[][] matrix) {
		 for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix.length / 2; j++) {
	            	
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[i][matrix.length - 1 - j];
	                matrix[i][matrix.length - 1 - j] = temp;
	            }
	        }
	}

	private static void transpose(int[][] matrix) {
		for(int i = 0 ; i<matrix.length ; i++) {
			for(int j = i ; j <matrix[i].length ; j++) {
				swap(matrix, i, j);
			}
		}
		
	}

	private static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
}
