package com.pinaki.arrayProlems;

import java.util.Arrays;

/*
 * Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence
 *  which contains the consecutive elements.

Examples:

Example 1:

Input: [100, 200, 1, 3, 2, 4]

Output: 4

Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
 * */
public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int [] arr = {100, 200, 1, 3, 2, 4};
		int ans = longestConsecutiveSequence(arr);
		System.out.println("LongestConsecutiveSequence is : "+ans);
	}

	private static int longestConsecutiveSequence(int[] arr) {
		Arrays.sort(arr);
		int  curr_max=1 , max_so_far = 0;
		for(int i = 1 ; i<arr.length ; i++) {
			if(arr[i]==arr[i-1]+1) {
				curr_max++;
			}else if(arr[i] != arr[i-1]){
				curr_max = 1;
			}
			max_so_far = Math.max(curr_max, max_so_far);
		}
		return max_so_far;
	}

}
