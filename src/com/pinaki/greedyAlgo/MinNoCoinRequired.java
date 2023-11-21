package com.pinaki.greedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class MinNoCoinRequired {
	/*
	 * 
	 * Problem Statement: Given a value V, if we want to make a change for V Rs, and
	 * we have an infinite supply of each of the denominations in Indian currency,
	 * i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000}
	 * valued coins/notes, what is the minimum number of coins and/or notes needed
	 * to make the change.
	 * 
	 * Examples: Input: V = 70
	 * 
	 * Output: 2
	 * 
	 * Explanation: We need a 50 Rs note and a 20 Rs note.
	 */
	static int minCoins(int coin[], int n, int amount) {
		Arrays.sort(coin);

		int res = 0;
		System.out.println("The coins are : ");
		for (int i = n - 1; i >= 0; i--) {
			if (coin[i] <= amount) {
				int c = (int) Math.floor(amount / coin[i]);

				res  += c;
				

				amount -= c * coin[i];
				System.out.println(c+" number of coin of "+coin[i]+" RS");
			}

			if (amount == 0)
				break;
		}

		return res;
	}

	public static void main(String[] args) {

		int amount = 49;
		ArrayList<Integer> ans = new ArrayList<>();
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int n = coins.length;
		for (int i = n - 1; i >= 0; i--) {
			while (amount >= coins[i]) {
				amount -= coins[i];
				ans.add(coins[i]);
			}
		}
		System.out.println("The minimum number of coins is : " + ans.size());
		System.out.println("The coins are : ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(" " + ans.get(i));
		}
		System.out.println();
		System.out.println("Another Approach : ");
		int coin[] = { 5, 10, 2, 1 };
		n = 4;
		amount = 57;
		System.out.println("total coin required : " +minCoins(coin, n, amount));

	}
}
