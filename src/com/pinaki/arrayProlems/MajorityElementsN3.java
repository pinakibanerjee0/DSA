package com.pinaki.arrayProlems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementsN3 {

	/*
	 * Optimal Approach (Extended Boyer Moore’s Voting Algorithm): Approach:
	 * Initialize 4 variables: cnt1 & cnt2 – for tracking the counts of elements el1
	 * & el2 – for storing the majority of elements. Traverse through the given
	 * array. If cnt1 is 0 and the current element is not el2 then store the current
	 * element of the array as el1 along with increasing the cnt1 value by 1. If
	 * cnt2 is 0 and the current element is not el1 then store the current element
	 * of the array as el2 along with increasing the cnt2 value by 1. If the current
	 * element and el1 are the same increase the cnt1 by 1. If the current element
	 * and el2 are the same increase the cnt2 by 1. Other than all the above cases:
	 * decrease cnt1 and cnt2 by 1. The integers present in el1 & el2 should be the
	 * result we are expecting. So, using another loop, we will manually check their
	 * counts if they are greater than the floor(N/3).
	 */
	public static List<Integer> majorityElement(int[] v) {
		int n = v.length; // size of the array

		int cnt1 = 0, cnt2 = 0; // counts
		int candidate1 = Integer.MIN_VALUE; // element 1
		int candidate2 = Integer.MIN_VALUE; // element 2

		// applying the Extended Boyer Moore's Voting Algorithm:
		for (int i = 0; i < n; i++) {
			if (cnt1 == 0 && candidate2 != v[i]) {
				cnt1 = 1;
				candidate1 = v[i];
			} else if (cnt2 == 0 && candidate1 != v[i]) {
				cnt2 = 1;
				candidate2 = v[i];
			} else if (v[i] == candidate1)
				cnt1++;
			else if (v[i] == candidate2)
				cnt2++;
			else {
				cnt1--;
				cnt2--;
			}
		}

		List<Integer> ls = new ArrayList<>(); // list of answers

		// Manually check if the stored elements in
		// candidate1 and candidate2 are the majority elements:
		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < n; i++) {
			if (v[i] == candidate1)
				cnt1++;
			if (v[i] == candidate2)
				cnt2++;
		}

		int mini = (int) (n / 3) + 1;
		if (cnt1 >= mini)
			ls.add(candidate1);
		if (cnt2 >= mini)
			ls.add(candidate2);

		// Uncomment the following line
		// if it is told to sort the answer array:
		// Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

		return ls;
	}

	public static void main(String args[]) {
		int[] arr = { 11, 33, 33, 11, 33, 11, 25, 70 };
		List<Integer> ans = majorityElement(arr);
		System.out.print("The majority elements are: ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
	}

	/*
	 * Time Complexity: O(N) + O(N), where N = size of the given array. Reason: The
	 * first O(N) is to calculate the counts and find the expected majority
	 * elements. The second one is to check if the calculated elements are the
	 * majority ones or not.
	 * 
	 * Space Complexity: O(1) as we are only using a list that stores a maximum of 2
	 * elements. The space used is so small that it can be considered constant.
	 * 
	 */
}
