package com.pinaki.arrayProlems;

import java.util.Arrays;

/*
Type I: At most one transaction is allowed

Given an array prices[] of length N, representing the prices of the stocks on different days, 
the task is to find the maximum profit possible for buying and selling the stocks on different days
 using transactions where at most one transaction is allowed.

Note: Stock must be bought before being sold.

Examples:

Input: prices[] = {7, 1, 5, 3, 6, 4]
Output: 5
Explanation:
The lowest price of the stock is on the 2nd day, i.e. price = 1. Starting from the 2nd day, 
the highest price of the stock is witnessed on the 5th day, i.e. price = 6. 
Therefore, maximum possible profit = 6 – 1 = 5. 
*/
/*
Approach 1:
This problem can be solved using the greedy approach. To maximize the profit we have to minimize the buy cost and we have to sell it at maximum price. 
Follow the steps below to implement the above idea:

Declare a buy variable to store the buy cost and max_profit to store the maximum profit.
Initialize the buy variable to the first element of the prices array.
Iterate over the prices array and check if the current price is minimum or not.
If the current price is minimum then buy on this ith day.
If the current price is greater than the previous buy then make profit from it and maximize the max_profit.
Finally, return the max_profit.
Below is the implementation of the above approach:
*/
public class BestTimetoBuyAndSellStock {
	static int maxProfit(int prices[], int n) {
		int buy = prices[0], max_profit = 0;
		for (int i = 1; i < n; i++) {

			// Checking for lower buy value
			if (buy > prices[i])
				buy = prices[i];

			// Checking for higher profit
			else if (prices[i] - buy > max_profit)
				max_profit = prices[i] - buy;
		}
		return max_profit;
	}

	// Driver Code
	public static void main(String args[]) {
		int prices[] = { 7, 1, 5, 6, 4 };
		int n = prices.length;
		int max_profit = maxProfit(prices, n);
		int max_profit_with_infinite_transaction = maxProfit(prices);
		System.out.println(max_profit);
		System.out.println(max_profit_with_infinite_transaction);

	}

	/*
	 * Time Complexity: O(N). Where N is the size of prices array. Auxiliary Space:
	 * O(1). We do not use any extra space.
	 */

	/*
	 * Type II: Infinite transactions are allowed
	 * 
	 * Examples:
	 * 
	 * Input: prices[] = {7, 1, 5, 3, 6, 4} Output: 7 Explanation: Purchase on 2nd
	 * day. Price = 1. Sell on 3rd day. Price = 5. Therefore, profit = 5 – 1 = 4.
	 * Purchase on 4th day. Price = 3. Sell on 5th day. Price = 6. Therefore, profit
	 * = 4 + (6 – 3) = 7.
	 * 
	 * Input: prices = {1, 2, 3, 4, 5} Output: 4 Explanation: Purchase on 1st day.
	 * Price = 1. Sell on 5th day. Price = 5. Therefore, profit = 5 – 1 = 4.
	 * 
	 * Approach: The idea is to maintain a boolean value that denotes if there is
	 * any current purchase ongoing or not. If yes, then at the current state, the
	 * stock can be sold to maximize profit or move to the next price without
	 * selling the stock. Otherwise, if no transaction is happening, the current
	 * stock can be bought or move to the next price without buying.
	 */

	// Function to find maximum profit possible
	// by buying and selling at most one stack
	static int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return findMaximumProfitWithInfiniteTransaction(0, 1, prices, dp);
	}

	static int findMaximumProfitWithInfiniteTransaction(int i, int k, int[] prices, int[][] dp) {

		if (i == prices.length)
			return 0;
		if (dp[i][k] != -1)
			return dp[i][k];
		int profit = 0;
		if (k == 1) {
			int buy = -prices[i] + findMaximumProfitWithInfiniteTransaction(i + 1, 0, prices, dp);
			int notBuy = findMaximumProfitWithInfiniteTransaction(i + 1, 1, prices, dp);
			profit = Math.max(buy, notBuy);
		} else {
			int sell = prices[i] + findMaximumProfitWithInfiniteTransaction(i + 1, 1, prices, dp);
			int notSell = findMaximumProfitWithInfiniteTransaction(i + 1, 0, prices, dp);
			profit = Math.max(sell, notSell);
		}

		return dp[i][k] = profit;
	}
}
