package com.pinaki.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	/*
	 * 
	 * Given a circular integer array nums (i.e., the next element of
	 * nums[nums.length - 1] is nums[0]), return the next greater number for every
	 * element in nums.
	 * 
	 * The next greater number of a number x is the first greater number to its
	 * traversing-order next in the array, which means you could search circularly
	 * to find its next greater number. If it doesn't exist, return -1 for this
	 * number.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
	 * greater number is 2; The number 2 can't find next greater number. The second
	 * 1's next greater number needs to search circularly, which is also 2.
	 */

	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int nge[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
				st.pop();
			}

			if (i < n) {
				if (st.isEmpty() == false)
					nge[i] = st.peek();
				else
					nge[i] = -1;
			}

			st.push(nums[i % n]);
		}
		return nge;
	}

	public static int[] nextGreaterElementII(int[] nums1, int[] nums2) {
		// map for next greater element
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums2) {
			// Pop elements from stack and update map with next greater element
			while (!stack.empty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		// Check if each element in nums1 has a next greater element in map
		for (int i = 0; i < nums1.length; i++) {
			// Update element in nums1 with next greater element or -1
			nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
		}
		return nums1;
	}

	public static void main(String args[]) {
		int arr[] = { 5, 7, 1, 2, 6, 0 };

		int arr2[] = nextGreaterElements(arr);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		int [] nums1 = {4,1,2}, nums2 = {1,3,4,2};
		arr2 = nextGreaterElementII(nums1 , nums2);
		System.out.println("The next greater elements II are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}
}
