package com.pinaki.StackAndQueue;

import java.util.Stack;

public class Practice {
	public static void main(String[] args) {

		String s = "]()[{}()]";
		if (isValid(s) == true)
			System.out.println("True");
		else
			System.out.println("False");
	}

	private static boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();

		for (Character ch : s.toCharArray()) {
			if ((ch == '(') || (ch == '{') || (ch == '['))
				st.push(ch);
			else {
				if (st.isEmpty())
					return false;
				Character stTop = st.pop();
				if ((ch == ')' && stTop == '(') || (ch == '}' && stTop == '{') || (ch == ']' && stTop == '['))
					continue;
				else
					return false;
			}
		}

		return st.isEmpty();
	}
}
