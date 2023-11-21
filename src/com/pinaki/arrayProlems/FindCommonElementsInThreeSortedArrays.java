package com.pinaki.arrayProlems;

/*
Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples: 

Input: 
ar1[] = {1, 5, 10, 20, 40, 80} 
ar2[] = {6, 7, 20, 80, 100} 
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
Output: 20, 80

Input: 
ar1[] = {1, 5, 5} 
ar2[] = {3, 4, 5, 5, 10} 
ar3[] = {5, 5, 10, 20} 
Output: 5, 5

A simple solution is to first find intersection of two arrays and store the intersection in a temporary array, then find the intersection of third array and temporary array. 
Time complexity of this solution is O(n1 + n2 + n3) where n1, n2 and n3 are sizes of ar1[], ar2[] and ar3[] respectively.
The above solution requires extra space and two loops, we can find the common elements using a single loop and without extra space. 
The idea is similar to intersection of two arrays. Like two arrays loop, we run a loop and traverse three arrays. 
Let the current element traversed in ar1[] be x, in ar2[] be y and in ar3[] be z. We can have following cases inside the loop. 

If x, y and z are same, we can simply print any of them as common element and move ahead in all three arrays.
Else If x < y, we can move ahead in ar1[] as x cannot be a common element.
Else If x > z and y > z), we can simply move ahead in ar3[] as z cannot be a common element. */
public class FindCommonElementsInThreeSortedArrays {

	public static void main(String args[])
	{
		FindCommonElementsInThreeSortedArrays ob = new FindCommonElementsInThreeSortedArrays();

		int ar1[] = { 1, 5, 10, 20, 40, 80 };
		int ar2[] = { 6, 7, 20, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.println("Common elements are : ");
		ob.findCommon(ar1, ar2, ar3);
		
		//using binary Search
		System.out.println("Common elements using binary Search are : ");
		ob.findCommonUsingBinarySearch(ar1, ar2, ar3, ar1.length, ar2.length, ar3.length);
	}

	/*Time complexity: O(n1(log(n2*n3))
	Auxiliary complexity: O(1)*/
	private void findCommonUsingBinarySearch(int[] ar1, int[] ar2, int[] ar3, int ar1Length, int ar2Length, int ar3Length) {
		for (int j = 0; j < ar1Length; j++) {
			if (j != 0 && ar1[j] == ar1[j - 1]) {
				continue;
			}
			// check if the element is present in 2nd and 3rd
			// array.
			if (binary_search(ar2, ar2Length, ar1[j])
				&& binary_search(ar3, ar3Length, ar1[j])) {
				System.out.print(ar1[j] +" , ");
			}
		}
	}

	private boolean binary_search(int[] arr, int arrLength, int x) {
		int s = 0;
		int e = arrLength -1;
		
		while(s<e) {
			int mid = s + (e-s)/2;
			if(arr[mid]==x) return true;
			else if(arr[mid]>x) e = mid -1;
			else {
				s = mid+1;
			}
		}
		return false;
	}

	private void findCommon(int[] ar1, int[] ar2, int[] ar3) {

		int i=0,j=0,k = 0;
		
		while(i<ar1.length && j<ar2.length && k<ar3.length) {
			if(ar1[i]==ar2[j] && ar2[j]==ar3[k]) {
				System.out.println(ar1[i]+" , ");
				i++; j++; k++;
			}else if(ar1[i]<ar2[j] && ar1[i]<ar3[k]) {
				i++;
			}else if(ar2[j]<ar1[i] && ar2[j]<ar3[k]) {
				j++;
			}else {
				k++;
			}
		}
		
	}
}

/*Time complexity of the above solution is O(n1 + n2 + n3). In the worst case, the largest sized array may have all small elements and middle-sized array has all middle elements.
Auxiliary Space:   O(1) */
