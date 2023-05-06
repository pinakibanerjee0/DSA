package com.pinaki.arrayProlems;

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
		System.out.println(max_profit);
	}
}

/*
 * Time Complexity: O(N). Where N is the size of prices array. Auxiliary Space:
 * O(1). We do not use any extra space.
 */
