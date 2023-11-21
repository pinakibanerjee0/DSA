package com.pinaki.arrayProlems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.

Example:

Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
Output: {{1, 9}} 
*/
/*
Merge Overlapping Intervals Optimized Approach

The idea to solve this problem is, first sort the intervals according to the starting time. 
Once we have the sorted intervals, we can combine all intervals in a linear traversal. 

The idea is, in sorted array of intervals, if interval[i] doesn’t overlap with interval[i-1], 
then interval[i+1] cannot overlap with interval[i-1] because starting time of interval[i+1] must be 
greater than or equal to interval[i].

1. Sort the intervals based on the increasing order of starting time.
2. Push the first interval into a stack.
3. For each interval do the following:
	If the current interval does not overlap with the top of the stack then,
	 	push the current interval into the stack.
	If the current interval overlap with the top of the stack then, 
		update the stack top with the ending time of the current interval.
4.The end stack contains the merged intervals. 

Below is the implementation of the above approach:
*/
public class MergeOverlappingIntervals {
	// The main function that takes a set of intervals, merges overlapping intervals
	// and prints the result
	public static void mergeIntervals(Interval arr[]) {
		// Test if the given set has at least one interval
		if (arr.length <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> stack = new Stack<>();

		// sort the intervals in increasing order of start time
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		// push the first interval to stack
		stack.push(arr[0]);

		// Start from the next interval and merge if necessary
		for (int i = 1; i < arr.length; i++) {
			// get interval from stack top
			Interval top = stack.peek();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.end < arr[i].start)
				stack.push(arr[i]);

			// Otherwise update the ending time of top if ending of current
			// interval is more
			else if (top.end < arr[i].end) {
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}
		}

		// Print contents of stack
		System.out.print("The Merged Intervals are: ");
		while (!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.print("[" + t.start + "," + t.end + "] ");
		}
	}

	public static void main(String args[]) {
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(2, 3);
		arr[2] = new Interval(1, 4);
		arr[3] = new Interval(5, 7);
		//mergeIntervals(arr);
		mergeIntervalsWithConstantExtraSpace(arr);
	}
	// Time complexity: O(N*log(N)) Auxiliary Space: O(N)

	/*
	 * Merge Overlapping Intervals Space Optimized Approach The above solution
	 * requires O(n) extra space for the stack. We can avoid the use of extra space
	 * by doing merge operations in place. Below are detailed steps.
	 * 
	 * Follow the steps mentioned below to implement the approach:
	 * 
	 * 1. Sort all intervals in increasing order of start time. 
	 * 2. Traverse sorted
	 * intervals starting from the first interval, 
	 * 3. Do the following for every  interval. 
	 * If the current interval is not the first interval and it overlaps
	 * with the previous interval, then merge it with the previous interval. Keep
	 * doing it while the interval overlaps with the previous one. Otherwise, Add
	 * the current interval to the output list of intervals. Below is the
	 * implementation of the above approach:
	 */

	public static void mergeIntervalsWithConstantExtraSpace(Interval arr[]) {
		// Sort Intervals in increasing order of
		// start time
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int index = 0; // Stores index of last element in output array (modified arr[])

		// Traverse all input Intervals
		for (int i = 1; i < arr.length; i++) {
			// If this is not first Interval and overlaps
			// with the previous one
			if (arr[index].end >= arr[i].start) {
				// Merge previous and current Intervals
				arr[index].end = Math.max(arr[index].end, arr[i].end);
			} else {
				index++;
				arr[index] = arr[i];
			}
		}

		// Now arr[0..index-1] stores the merged Intervals
		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i <= index; i++) {
			System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
		}
	}

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}

//Time Complexity: O(N*log(N))
//Auxiliary Space Complexity: O(1)