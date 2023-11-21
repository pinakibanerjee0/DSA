package com.pinaki.binarySearch;

public class KthEementTwoSortedArrays {
	/*
	 * 
	 * Given two sorted arrays arr1 and arr2 of size N and M respectively and an
	 * element K. The task is to find the element that would be at the kth position
	 * of the final sorted array.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: arr1[] = {2, 3, 6, 7, 9} arr2[] = {1, 4, 8, 10} k = 5 Output: 6
	 * Explanation: The final sorted array would be : {1, 2, 3, 4, 6, 7, 8, 9, 10}
	 * The 5th element of this array is 6.
	 * 
	 * https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/
	 */

	public static long  kthElement(int arr1[], int arr2[], int arr1_size, int arr2_size, int k)
    {
		//arr2 size should be greater than arr1 size : i,e arr1 should be a smaller array than arr2
        if(arr1_size>arr2_size) return kthElement( arr2, arr1, arr2_size, arr1_size, k);
        
        int low =Math.max(0,k-arr2_size) , high = Math.min(k,arr1_size);
        while(low<=high){
            int cut1 =(low+high) >> 1; //divide by 2
            int cut2 = k-cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE  : arr1[cut1 -1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 -1];
            int r1 = cut1 == arr1_size ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == arr2_size ? Integer.MAX_VALUE : arr2[cut2];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1>r2){
                high = cut1 - 1;
            }else{
                low = cut1+1;
            }
            
        }
        return 1;
    }
	public static void main(String[] args) {

		int[] arr1 = { 2, 3, 6, 7, 9 };
		int[] arr2 = { 1, 4, 8, 10 };
		int k = 5 ;
		long element = kthElement(arr1 , arr2 , arr1.length , arr2.length , k);
		System.out.println("The element that would be at the kth position of the final sorted array. is : " + element);
	}
}

