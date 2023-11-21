package com.pinaki.binarySearch;

public class Practice {

	public static void main(String[] args) {

		/*
		 * // search in a sorted rotated array : int[] arr = { 4,5,6,7,9,0,1,2 }; int
		 * element = 0; int index = search(arr , element );
		 * System.out.println("The element appears at the index :" + index);
		 */
		/*
		 * int n = 2, m = 16; System.out.println("The N'th root of the number " + m +
		 * " is : " + getNthRoot(n, m));
		 * 
		 */
		int[] arr = { 1, 1, 3, 3, 4, 4, 6, 6, 8, 8, 9 };

		int element = singleNonDuplicate(arr);
		System.out.println("The single element that appears only once is :" + element);

	}

	private static int singleNonDuplicate(int[] arr) {
		int s = 0, e = arr.length -2;
		
		while(s<=e) {
			int mid = s +(e-s)/2;
			if((mid % 2 == 0 && (arr[mid] != arr[mid + 1])) && (mid % 2 != 0 && (arr[mid] == arr[mid + 1]))){
				e = mid -1;
			}else {
				s = mid +1;
			}
		}
		return arr[s];
	}

	private static int getNthRoot(int n, int m) {
		int s = 1, e = m;

		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (Math.pow(n, mid) == m)
				return mid;
			else if (Math.pow(n, mid) > m)
				e = mid - 1;
			else
				s = mid + 1;
		}

		return -1;
	}

	private static int search(int[] arr, int element) {
		int ans = -1;
		int n = arr.length;
		if (n == 0)
			return ans;
		if (n == 1) {
			if (arr[0] == element)
				return 0;
			else
				return ans;
		}

		int pivot = getPivot(arr);
		System.out.println(pivot);
		if (element >= arr[pivot] && element <= arr[n - 1]) {
			ans = binarySearc(arr, pivot, n - 1, element);
		} else {
			ans = binarySearc(arr, 0, pivot + 1, element);
		}

		return ans;
	}

	private static int binarySearc(int[] arr, int s, int e, int element) {
		int mid = s + (e - s) / 2;

		while (s <= e) {
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] > element) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
			mid = s + (e - s) / 2;
		}

		return -1;
	}

	private static int getPivot(int[] arr) {
		int s = 0, e = arr.length - 1;
		int mid = s + (e - s) / 2;

		while (s < e) {
			if (arr[mid] >= arr[0]) {
				s = mid + 1;
			} else {
				e = mid;
			}
			mid = s + (e - s) / 2;
		}
		return mid;
	}

}