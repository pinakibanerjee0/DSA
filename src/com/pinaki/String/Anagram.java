package com.pinaki.String;

public class Anagram {

	public static void main(String[] args) {
		String s = "Anagram?";
		String t = "gram?anA";
		System.out.println("is String t anagram of s ? "+isAnagram(s,t));
	}
	
	public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int [] alph = new int[256]; // int[150_00];
        for(int i = 0 ; i < s.length(); i++){
            alph[s.charAt(i)]++;
        }
        for(int i = 0 ; i < t.length(); i++){
            alph[t.charAt(i)]--;
        }

        for(int i : alph){
            if(i!=0) return false;
        }

        return true;
    }

}
