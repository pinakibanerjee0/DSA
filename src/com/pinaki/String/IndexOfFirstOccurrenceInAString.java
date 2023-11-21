package com.pinaki.String;

public class IndexOfFirstOccurrenceInAString {

	public static void main(String[] args) {
		String s = "mDay may day may";
		String b = "may";
		
		System.out.println("The Index Of First Occurrence of b In the String s is : "+strStr(s,b));
	}
	public static int strStr(String haystack, String needle) {
        int n = needle.length();
        if(n==0) return 0;

        int h = haystack.length();

        if(n>h) return -1;

        for(int i =0;i<=h-n ;i++){
            int j;
            for(j = 0 ;j<n ;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
            if(j==n) return i;
        }

        return -1;
    }
}
