package com.pinaki.String;

public class Practice {

	public static void main(String[] args) {
		String s = "Anagram?";
		String t = "gram?anA";
		System.out.println("is String t anagram of s ? "+isAnagram(s,t));
		
		String a = "mDay may day may";
		String b = "may";
		
		System.out.println("The Index Of First Occurrence of b In the String s is : "+strStr(a,b));
	}

	private static int strStr(String a, String b) {
		if(b.length()==0) return 0;
		if(b.length()>a.length()) return -1;
		
		for(int i = 0 ; i<a.length() - b.length() ; i++) {
			int j;
			for(j=0;j<b.length();j++) {
				if(a.charAt(i+j)!=b.charAt(j)) break;
			}
			if(j==b.length()) return i;
		}
		
		return -1;
	}

	private static boolean isAnagram(String s, String t) {
		
		if(s.length()!=t.length()) return false;
		int[] alph = new int[256];
		
		for(Character ch : s.toCharArray()) {
			alph[ch]++;
		}
		for(Character ch : t.toCharArray()) {
			alph[ch]--;
		}
		
		for(int i = 0 ; i<alph.length ; i++) {
			if(alph[i]!=0) return false;
		}
		
		return true;
	}
}
