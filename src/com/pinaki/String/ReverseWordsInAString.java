package com.pinaki.String;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String st = "I am Pinaki and I am doing interview preparation      ";
		System.out.println("Before reversing words: ");
		System.out.println(st);
		System.out.println("After reversing words: ");
		System.out.print(reverseWords(st));
	}

	public static String reverseWords(String s) {
		int n = s.length(); 
		// Initialize a StringBuilder to store the reversed words
		StringBuilder ans = new StringBuilder(); 
		// Start from the last character of the input string
		int i = n - 1; 

		while (i >= 0) {
			if (s.charAt(i) == ' ') {
				i--; // If the current character is a space, move to the next character
			} else {
				StringBuilder temp = new StringBuilder(" "); // Initialize a temporary StringBuilder with a space
																// character
				int j = i;
				while (j >= 0 && s.charAt(j) != ' ') {
					temp.append(s.charAt(j)); // Append each character to the temporary StringBuilder in reverse order
					j--;
				}
				ans.append(temp.reverse()); // Reverse the characters in the temporary StringBuilder and append to the
											// final StringBuilder
				// Update the index to continue from the next word
				i = j; 
			}
		}

		// Remove the extra space character appended at the end
		ans.deleteCharAt(ans.length() - 1); 

		return ans.toString();

	}

}
