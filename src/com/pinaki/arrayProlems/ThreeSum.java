package com.pinaki.arrayProlems;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Approach:
We could make use of the fact that we just need to return the triplets and thus could possibly sort the array.
 This would help us use a modified two-pointer approach to this problem.

Eg) Input :  [-1,0,1,2,-1,-4]

After sorting, our array is : [-4,-1,-1,0,1,2]

Notice, that we are fixing the i pointer and then applying the traditional 2 pointer approach 
to check whether the sum of three numbers equals zero. If the sum is less than zero,
 it indicates our sum is probably too less and we need to increment our j pointer to get a larger sum. 
 On the other hand, if our sum is more than zero, it indicates our sum is probably too large 
 and we need to decrement the k pointer to reduce the sum and bring it closer to zero.
 * 
 * */
public class ThreeSum {

	static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		Arrays.sort(num);

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		for (int i = 0; i < num.length - 2; i++) {

			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(num[i]);
						temp.add(num[lo]);
						temp.add(num[hi]);
						res.add(temp);

						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;

						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;

					else
						hi--;
				}
			}
		}
		return res;
	}
	/*
	 * Time Complexity : O(N^2)
	 * 
	 * Space Complexity : O(3*k) // k is the no.of triplets
	 */

	public static void main(String args[]) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };
		ArrayList<ArrayList<Integer>> ans;
		ans = threeSum(arr);
		System.out.println("The triplets are as follows: ");
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}
}
