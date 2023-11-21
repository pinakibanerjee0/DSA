package com.pinaki.StackAndQueue;

import java.util.Stack;

import com.pinaki.StackAndQueue.ImplementQueueUsingArray.Queue;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
	        q.push(4);
	        q.push(14);
	        q.push(24);
	        q.push(34);
	        System.out.println("The peek of the queue before deleting any element " + q.peek());
	        System.out.println("The first element to be deleted " + q.pop());
	        System.out.println("The peek of the queue after deleting an element " + q.peek());
	    
	}
	
	static class MyQueue {
		Stack<Integer> input;
		Stack<Integer> output;

		public MyQueue() {
			input = new Stack<>();
			output = new Stack<>();
		}

		public void push(int x) {
			while (!output.isEmpty()) {
				input.push(output.pop());
			}
			output.push(x);
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}

		public int pop() {
			return output.pop();
		}

		public int peek() {
			return output.peek();
		}

		public boolean empty() {
			return input.isEmpty() && output.isEmpty();
		}
	}
}
