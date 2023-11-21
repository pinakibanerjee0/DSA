package com.pinaki.binarySearch;

public class SingleElementInSortedArray {
	/*
	 * 
	 * You are given a sorted array consisting of only integers where every element
	 * appears exactly twice, except for one element which appears exactly once.
	 * 
	 * Return the single element that appears only once.
	 * 
	 * Your solution must run in O(log n) time and O(1) space.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,1,2,3,3,4,4,8,8] Output: 2
	 * https://takeuforward.org/data-structure/search-single-element-in-a-sorted-
	 * array/
	 */
	public static int singleNonDuplicate(int[] nums) {
		int s = 0, e = nums.length - 2;
		int ans = -1;

		while (s <= e) {
			int mid = s + (e - s) / 2;

			if ((mid % 2 == 0 && (nums[mid] != nums[mid + 1])) || (mid % 2 != 0 && (nums[mid] == nums[mid + 1]))) {
				e = mid - 1;
			} else {
				s = mid + 1;

			}
		}

		return nums[s];
	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 3, 3, 4, 4, 6,6, 8, 8,9 };

		int element = singleNonDuplicate(arr);
		System.out.println("The single element that appears only once is :" + element);
	}
}
