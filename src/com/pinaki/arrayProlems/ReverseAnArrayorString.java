package com.pinaki.arrayProlems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}
*/
public class ReverseAnArrayorString {
	public static void main(String args[]) {
		int arr[] =  {1, 2, 3};
		reverseArray(arr);
		System.out.printf("The reversed array is: ");
		System.out.println(Arrays.toString(arr));
		List<String> ls = new ArrayList<>();
		ls.add("as");
		ls.add("erg");

		ls.add("cb");

		ls.add("rty");

		ls.forEach(i ->System.out.println(i));

	}

	private static void reverseArray(int[] arr) {
		int s = 0;
		int e = arr.length -1;
		int tmp;
		while(s<e) {
			tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++; e--;
		}
		
	}
}
