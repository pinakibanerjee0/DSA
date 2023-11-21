package com.pinaki.String;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		/*
		 * 
		 * Given a string s, return the longest palindromic substring in s.
		 * 
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input: s = "babad" Output: "bab" Explanation: "aba" is also a valid answer.
		 * Example 2:
		 * 
		 * Input: s = "cbbd" Output: "bb"
		 */
		String s = "babad" ;
		System.out.println("The Longest Palindromic Substring of the given string "+s+" is : ");
		System.out.println(longestPalindrome(s));
		

	}
	
	public static String longestPalindrome(String s) {
        String max = "";
       for (int i = 0; i < s.length(); i++) {
           String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
           if (s1.length() > max.length()) max = s1;
           if (s2.length() > max.length()) max = s2;
       }
       return max;
   }

    private static String extend(String s, int i, int j) {
       for (; 0 <= i && j < s.length(); i--, j++) {
           if (s.charAt(i) != s.charAt(j)) break;
       }
       return s.substring(i + 1, j);
   }

}
