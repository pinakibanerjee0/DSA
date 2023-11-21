package com.pinaki.arrayProlems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Approach:

The steps are as follows:

First, we will sort the entire array.
We will use a loop(say i) that will run from 0 to n-1. 
This i will represent one of the fixed pointers. 

In each iteration, this value will be fixed for all different values of the rest of the 3 pointers.
 Inside the loop, we will first check if the current and the previous element 
 is the same and if it is we will do nothing and continue to the next value of i.
After checking inside the loop, we will introduce another fixed pointer j(runs from i+1 to n-1) using another loop. Inside this second loop, we will again check for duplicate elements and only perform any further operation if the elements are different.
Inside the second loop, there will be 2 moving pointers i.e. k(starts from j+1) and l(starts from the last index). The pointer k will move forward and the pointer l will move backward until they cross each other while the value of i and j will be fixed.
Now we will check the sum i.e. nums[i]+nums[j]+nums[k]+nums[l].
If the sum is greater, then we need lesser elements and so we will decrease the value of l.
If the sum is lesser than the target, we need a bigger value and so we will increase the value of k. 
If the sum is equal to the target, we will simply insert the quad i.e. nums[i], nums[j], nums[k], and nums[l] into our answer and move the pointers k and l skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
Finally, we will have a list of unique quadruplets.
 * */
public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length; // size of the array
		List<List<Integer>> ans = new ArrayList<>();

		// sort the given array:
		Arrays.sort(nums);

		// calculating the quadruplets:
		for (int i = 0; i < n; i++) {
			// avoid the duplicates while moving i:
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				// avoid the duplicates while moving j:
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				// 2 pointers:
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					long sum = nums[i];
					sum += nums[j];
					sum += nums[k];
					sum += nums[l];
					if (sum == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						ans.add(temp);
						k++;
						l--;

						// skip the duplicates:
						while (k < l && nums[k] == nums[k - 1])
							k++;
						while (k < l && nums[l] == nums[l + 1])
							l--;
					} else if (sum < target)
						k++;
					else
						l--;
				}
			}
		}

		return ans;
	}

	/*
	 * Time Complexity: O(N3), where N = size of the array. Reason: Each of the
	 * pointers i and j, is running for approximately N times. And both the pointers
	 * k and l combined can run for approximately N times including the operation of
	 * skipping duplicates. So the total time complexity will be O(N3).
	 * 
	 * Space Complexity: O(no. of quadruplets), This space is only used to store the
	 * answer. We are not using any extra space to solve this problem. So, from that
	 * perspective, space complexity can be written as O(1).
	 */

	public static void main(String[] args) {
		int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target = 9;
		List<List<Integer>> ans = fourSum(nums, target);
		System.out.println("The quadruplets are: ");
		for (List<Integer> it : ans) {
			System.out.print("[");
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.print("] ");
		}
		System.out.println();
	}

}
