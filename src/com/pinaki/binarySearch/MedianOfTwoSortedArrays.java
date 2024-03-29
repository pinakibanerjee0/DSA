package com.pinaki.binarySearch;

public class MedianOfTwoSortedArrays {

	/*
	 * 
	 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
	 * the median of the two sorted arrays.
	 * 
	 * The overall run time complexity should be O(log (m+n)).
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
	 * [1,2,3] and median is 2. Example 2:
	 * 
	 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
	 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 * 
	 * https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return findMedianSortedArrays(nums2 , nums1) ;

        int m = nums1.length , n = nums2.length ;
        int low =0 , high  = m , medianPos = (m+n+1)/2;

        while(low<=high){
            int cut1 = (low + high) /2;
            int cut2 = medianPos - cut1;
            int l1 = (cut1 == 0)? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2 == 0 )? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1<=r2 && l2<=r1){
                if((m+n)%2 != 0)
                    return Math.max(l1,l2);
                else 
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else if(l1>r2){
                high = cut1 - 1;
            }else{
                low = cut1+1;
            }
        }

        return 0.0;
        
    }
	
	public static void main(String[] args) {

		int[] arr1 = { 1,2 };
		int[] arr2 = { 3,4 };
		double median = findMedianSortedArrays(arr1 , arr2);
		System.out.println("The median of the two sorted arrays is : " + median);
	}
}
