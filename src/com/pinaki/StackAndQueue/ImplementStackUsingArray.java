package com.pinaki.StackAndQueue;

public class ImplementStackUsingArray {

	public static void main(String[] args) {

		Stack s = new Stack(100);
		s.push(6);
		s.push(3);
		s.push(7);
		System.out.println("Top of the stack before deleting any element " + s.top());
		System.out.println("Size of the stack before deleting any element " + s.size());
		System.out.println("The element deleted is " + s.pop());
		System.out.println("Size of the stack after deleting an element " + s.size());
		System.out.println("Top of the stack after deleting an element " + s.top());

	}

	public static class Stack {

		int top;
		int[] arr;

		public Stack(int capacity) {
			arr = new int[capacity];
			top = -1;
		}

		public int size() {
			return top + 1;
		}

		void push(int x) {
			top++;
			arr[top] = x;
		}

		int pop() {
			if (size() > 0) {
				int x = arr[top];
				top--;
				return x;
			}
			return -1;
		}

		int top() {
			if (size()  > 0) {
				return arr[top];
			}
			return -1;
		}

	}
}
