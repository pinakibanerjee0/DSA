package com.pinaki.binarySearch;

public class SearchRotatedSortedArray {
	/*
	 * 
	 * There is an integer array nums sorted in ascending order (with distinct
	 * values).
	 * 
	 * Prior to being passed to your function, nums is possibly rotated at an
	 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
	 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
	 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
	 * and become [4,5,6,7,0,1,2].
	 * 
	 * Given the array nums after the possible rotation and an integer target,
	 * return the index of target if it is in nums, or -1 if it is not in nums.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
	 */

	private static int pivotIndex(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		int mid = s + (e - s) / 2;

		while (s < e) {
			if (nums[mid] >= nums[0]) {
				s = mid + 1;
			} else {
				e = mid;
			}
			mid = s + (e - s) / 2;
		}
		return s;
	}

	private static int binarSearch(int[] nums, int s, int e, int target) {
		int mid = s + (e - s) / 2;
		int ans = -1;

		while (s <= e) {
			// System.out.println("mid is : "+mid);
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target) {
				e = mid - 1;
			} else if (nums[mid] < target) {
				s = mid + 1;
			}
			mid = s + (e - s) / 2;
		}
		return ans;
	}

	public static int search(int[] nums, int target) {
		int ans = -1;
		int n = nums.length;
		if (n == 0)
			return ans;
		if (n == 1) {
			if (nums[0] == target)
				return 0;
			else
				return ans;
		}

		int pivot = pivotIndex(nums);

		System.out.println("pivot is : "+pivot);
		if (target >= nums[pivot] && target <= nums[n - 1]) {
			ans = binarSearch(nums, pivot, n - 1, target);
		} else {
			ans = binarSearch(nums, 0, pivot - 1, target);
		}
		return ans;
	}
	
	public static void main(String[] args) {

		int[] arr = { 4,5,6,7,0,1,2 };
		int element = 0;
		int index = search(arr , element );
		System.out.println("The element appears at the index :" + index);
	}
}
