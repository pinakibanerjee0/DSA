package com.pinaki.arrayProlems;

import java.util.Random;

/*
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7
*/
public class KthSmallestLargestElementInUnsortedArray {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 4, 6, 8 };
		int k = 2;
		int kthLargest = findKthLargest(nums, k);
		System.out.println("The " + k + "th largest element is: " + kthLargest);
	}

	public static int findKthLargest(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;
		Random rand = new Random();
		while (left <= right) {
			int pivotIndex = rand.nextInt(right - left + 1) + left;
			int newIndex = partition(nums, left, right, pivotIndex);
			if (newIndex == k - 1) {
				return nums[newIndex];
			} else if (newIndex > k - 1) {
				right = newIndex - 1;
			} else {
				left = newIndex + 1;
			}
		}
		return -1; // kth largest element does not exist
	}

	public static int partition(int[] nums, int left, int right, int pivotIndex) {
		int pivotValue = nums[pivotIndex];
		swap(nums, pivotIndex, right);
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (nums[i] > pivotValue) {
				swap(nums, i, storeIndex);
				storeIndex++;
			}
		}
		swap(nums, storeIndex, right);
		return storeIndex;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
