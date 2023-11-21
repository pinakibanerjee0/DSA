package com.pinaki.binarySearch;

import java.util.ArrayList;

public class BookAllocation {
	/*
	 * 
	 * 
	 * Problem Statement: Given an array of integers A of size N and an integer B.
	 * 
	 * The College library has N bags, the ith book has A[i] number of pages.
	 * 
	 * You have to allocate books to B number of students so that the maximum number
	 * of pages allocated to a student is minimum.
	 * 
	 * Conditions given :
	 * 
	 * A book will be allocated to exactly one student.
	 * 
	 * Each student has to be allocated at least one book.
	 * 
	 * Allotment should be in contiguous order, for example, A student cannot be
	 * allocated book 1 and book 3, skipping book 2.
	 * 
	 * Calculate and return the minimum possible number. Return -1 if a valid
	 * assignment is not possible.
	 * 
	 * Examples:
	 * 
	 * Example 1:
	 * 
	 * Input: A = [12, 34, 67, 90] B = 2
	 * 
	 * Output: 113
	 * 
	 * Explaination: Let’s see all possible cases of how books can be allocated for
	 * each student.
	 * Student 1		Student 2				MAX
	 *{12}	  			{34 , 67 , 90}			191
	 *{12 , 34}			{67 ,90}				157
	 *{12 , 34 , 67}	{90}					113
	 * 
	 * 
	 * So, the maximum number of pages allocated in each case is [191,157,113]. So,
	 * the minimum number among them is 113. Hence, our result is 113.
	 */
	
	static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 1;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if ( sumAllocated > pages || cnt > students) return false;
                
            } else {
                sumAllocated += A.get(i);
            }
        }
        return true;
    }
    public static int books(ArrayList < Integer > A, int B) {
        if (B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for (int i = 0; i < A.size(); i++) {
            high = high + A.get(i);
            low = Math.min(low, A.get(i));
        }
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(A, mid, B)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return low -> this is also correct
        return res;
    }
    public static void main(String args[]) {
        ArrayList < Integer > A = new ArrayList < > ();
        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;
        System.out.println("Minimum Possible Number is : " + books(A, B));
    }
}
