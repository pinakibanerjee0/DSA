package com.pinaki.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	/*
	 * 
	 * Problem Statement: Given a collection of candidate numbers (candidates) and a
	 * target number (target), find all unique combinations in candidates where the
	 * candidate numbers sum to target. Each number in candidates may only be used
	 * once in the combination.
	 * 
	 * Note: The solution set must not contain duplicate combinations.
	 * 
	 * Examples:
	 * 
	 * Example 1:
	 * 
	 * Input: candidates = [10,1,2,7,6,1,5], target = 8
	 * 
	 * Output: [ [1,1,6], [1,2,5], [1,7], [2,6]]
	 * 
	 * 
	 * Explanation: These are the unique combinations whose sum is equal to target.
	 * 
	 * 
	 * Before starting the recursive call make sure to sort the elements because the
	 * ans should contain the combinations in sorted order and should not be
	 * repeated.
	 * 
	 * Initially, We start with the index 0, At index 0 we have n – 1 way to pick
	 * the first element of our subsequence.
	 * 
	 * Check if the current index value can be added to our ds. If yes add it to the
	 * ds and move the index by 1. while moving the index skip the consecutive
	 * repeated elements because they will form duplicate sequences.
	 * 
	 * Reduce the target by arr[i],call the recursive call for f(idx + 1,target –
	 * 1,ds,ans) after the call make sure to pop the element from the ds.(By seeing
	 * the example recursive You will understand).
	 * 
	 * if(arr[i] > target) then terminate the recursive call because there is no use
	 * to check as the array is sorted in the next recursive call the index will be
	 * moving by 1 all the elements to its right will be in increasing order.
	 * 
	 * 
	 * Base Condition: Whenever the target value is zero add the ds to the ans
	 * return.
	 */

	static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (target == 0) {//Base Condition
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;

			ds.add(arr[i]);
			findCombinations(i + 1, arr, target - arr[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String args[]) {
		int v[] = { 10, 1, 2, 7, 6, 5 };
		List<List<Integer>> comb = combinationSum2(v, 8);
		System.out.println("all the unique combinations in candidates where the candidate numbers sum to target is : ");
		System.out.println(comb.toString().replace(",", " "));
	}
}
