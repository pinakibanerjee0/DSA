package com.pinaki.greedyAlgo;

import java.io.IOException;
import java.util.Arrays;

public class JobSequencing {

	/*
	 * 
	 * Given a set of N jobs where each jobid has a deadline and profit associated
	 * with it.
	 * 
	 * Each job takes 1 unit of time to complete and only one job can be scheduled
	 * at a time. We earn the profit associated with job if and only if the job is
	 * completed by its deadline.
	 * 
	 * Find the number of jobs done and the maximum profit.
	 * 
	 * Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated
	 * with that Job.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: N = 4 Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)} Output: 2 60
	 * Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
	 */
	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		int maxi = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxi) {
				maxi = arr[i].deadline;
			}
		}

		int result[] = new int[maxi + 1];

		for (int i = 1; i <= maxi; i++) {
			result[i] = -1;
		}

		int countJobs = 0, jobProfit = 0;

		for (int i = 0; i < n; i++) {

			for (int j = arr[i].deadline; j > 0; j--) {

				// Free slot found
				if (result[j] == -1) {
					result[j] = i;
					countJobs++;
					jobProfit += arr[i].profit;
					break;
				}
			}
		}

		return new int[] { countJobs, jobProfit };

	}

	public static void main(String[] args) throws IOException {

		// size of array
		Job[] arr = new Job[4];
		arr[0] = new Job(1,4,20);
		arr[1] = new Job(2,1,10);
		arr[2] = new Job(3,1,40);
		arr[3] = new Job(4,1,30);

		// function call
		int[] res = JobScheduling(arr, 4);
		System.out.println("No of jobs performrd : "+res[0] + " \nMaximum profit : " + res[1]);

	}

	public static class Job {
		int id, profit, deadline;

		Job(int x, int y, int z) {
			this.id = x;
			this.deadline = y;
			this.profit = z;
		}
	}
}
