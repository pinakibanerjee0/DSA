package com.pinaki.arrayProlems;

/*

Example:
Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1}
Output: 1, 3, 6

Explanation: The numbers 1 , 3 and 6 appears more
than once in the array.

https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

Approach: 

The basic idea is to use a HashMap to solve the problem. But there is a catch, the numbers in the array are from 0 to n-1,
and the input array has length n. So, the input array can be used as a HashMap. While Traversing the array,
if an element �a� is encountered then increase the value of a%n�th element by n. 
The frequency can be retrieved by dividing the a % n�th element by n.

Algorithm: 

Traverse the given array from start to end.
For every element in the array increment the arr[i]%n�th element by n.
Now traverse the array again and print all those indexes i for which arr[i]/n is greater than 1. Which guarantees that the number n has been added to that index
This approach works because all elements are in the range from 0 to n-1 and arr[i] would be greater than n only if a value �i� has appeared more than once.
*/
public class FindDuplicates {
	public static void main(String args[]) {
		int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };

		for (int i = 0; i < numRay.length; i++) {
			numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
		}
		System.out.println("The repeating elements are : ");
		for (int i = 0; i < numRay.length; i++) {
			if (numRay[i] >= numRay.length * 2) {
				System.out.println(i + " ");
			}
		}
	}
}
/*
Complexity Analysis: 

Time Complexity: O(n), Only two traversals are needed. So the time complexity is O(n).
Auxiliary Space: O(1), No extra space is needed, so the space complexity is constant.
*/
