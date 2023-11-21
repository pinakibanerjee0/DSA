package com.pinaki.greedyAlgo;

import java.util.Arrays;

public class FractionalKnapsack {
	/*
	 * 
	 * Problem Statement: The weight of N items and their corresponding values are
	 * given. We have to put these items in a knapsack of weight W such that the
	 * total value obtained is maximized.
	 * 
	 * Note: We can either take the item as a whole or break it into smaller units.
	 * 
	 * Example:
	 * 
	 * Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.
	 * 
	 * Output: 240.00
	 * 
	 * Explanation: The first and second items are taken as a whole while only 20
	 * units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
	 * 
	 */

	// Function to get the maximum total value in the knapsack.
	static double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr,
				(i1, i2) -> (((double) i1.value / (double) i1.weight) > ((double) i2.value / (double) i2.weight) ? -1
						: ((double) i1.value / (double) i1.weight) < ((double) i2.value / (double) i2.weight) ? 1 : 0));

		int curWeight = 0;
		double finalvalue = 0.0;

		for (int i = 0; i < n; i++) {

			if (curWeight + arr[i].weight <= W) {
				curWeight += arr[i].weight;
				finalvalue += arr[i].value;
			}

			else {
				int remain = W - curWeight;
				finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
				break;
			}
		}

		return finalvalue;
	}

	public static class Item {
		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}
	}

	public static void main(String args[]) {
		int n = 3, weight = 50;
		Item arr[] = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
		double ans = fractionalKnapsack(weight, arr, n);
		System.out.println("The maximum value is " + ans);
	}
}
