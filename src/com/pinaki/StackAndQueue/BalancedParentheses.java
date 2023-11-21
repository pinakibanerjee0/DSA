package com.pinaki.StackAndQueue;

import java.util.Stack;

public class BalancedParentheses {
	/*
	 * 
	 * Problem Statement: Check Balanced Parentheses. Given string str containing
	 * just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, check if the input
	 * string is valid and return true if the string is balanced otherwise return
	 * false.
	 * 
	 * Note: string str is valid if:
	 * 
	 * Open brackets must be closed by the same type of brackets. Open brackets must
	 * be closed in the correct order. Example 1:
	 * 
	 * Input: str = “( )[ { } ( ) ]”
	 * 
	 * Output: True
	 * 
	 * Explanation: As every open bracket has its corresponding close bracket. Match
	 * parentheses are in correct order hence they are balanced.
	 */

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for (char it : s.toCharArray()) {
			if (it == '(' || it == '[' || it == '{')
				st.push(it);
			else {
				if (st.isEmpty())
					return false;
				char ch = st.pop();
				if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{'))
					continue;
				else
					return false;
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {

		String s = "()[{}()]";
		if (isValid(s) == true)
			System.out.println("True");
		else
			System.out.println("False");
	}
}
