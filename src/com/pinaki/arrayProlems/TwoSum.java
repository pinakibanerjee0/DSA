package com.pinaki.arrayProlems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String args[]) {
		int arr[] =  {1, 2, 3, 4, 5, 6};
		
		int[] twoSum = twoSum(arr, 10);
		System.out.printf("The elements of the array is: ");
		System.out.println(Arrays.toString(twoSum));
		
		int[] twoSumIndices = twoSumIndices(arr, 10);
		System.out.printf("The indices of the array is: ");
		System.out.println(Arrays.toString(twoSumIndices));

	}
	
	public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0 , high = nums.length - 1 ; 

        while(low<high){
            if(nums[low]+nums[high] == target) return new int [] {nums[low] , nums[high]};
            else if(nums[low]+nums[high] > target) high --;
            else low++;
        }
        return new int [] {-1 , -1};
    }
	
	 public static int[] twoSumIndices(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            int complement = target - nums[i];
	            if (map.containsKey(complement)) {
	                return new int[] { map.get(complement), i };
	            }
	            map.put(nums[i], i);
	        }
	        return new int[] {-1, -1};
	    }
}
