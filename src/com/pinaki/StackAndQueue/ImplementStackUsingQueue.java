package com.pinaki.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
	
	public static void main(String [] args) {
		
		//MyStack stk = new MyStack();
		
		Stack stk = new Stack();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		
		System.out.println("Top of the stack: " + stk.top());
        System.out.println("Size of the stack before removing element: " + stk.size());
        System.out.println("The deleted element is: " + stk.pop());
        System.out.println("Top of the stack after removing element: " + stk.top());
        System.out.println("Size of the stack after removing element: " + stk.size());
	}
	
	//using only one queue
	static class Stack {
	    Queue < Integer > q = new LinkedList < > ();
	    void push(int x) {
	        q.add(x);
	        for (int i = 0; i < q.size() - 1; i++) {
	            q.add(q.remove());
	        }
	    }
	    int pop() {
	        return q.remove();
	    }
	    int top() {
	        return q.peek();
	    }
	    int size() {
	        return q.size();
	    }
	}

	//using two queue
	static class MyStack {
	    Queue<Integer> q1;
	    Queue<Integer> q2;

	    public MyStack() {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	    }
	    
	    public int size() {
			if(empty()) return -1;
			if(!q1.isEmpty()) {
				return q1.size();
			}else {
				return q2.size();
			}
			
		}

		public void push(int x) {
	        if(q2.isEmpty()){
	            q2.add(x);

	            while(!q1.isEmpty()){
	                q2.add(q1.remove());
	            }
	        }else{
	            q1.add(x);

	            while(!q2.isEmpty()){
	                q1.add(q2.remove());
	            }
	        }    
	    }
	    
	    public int pop() {
	        if(empty()) return -1;
	        if(q2.isEmpty()){
	            return q1.remove();
	        }else{
	            return q2.remove();
	        }
	    }
	    
	    public int top() {
	        if(empty()) return -1;
	        if(q2.isEmpty()){
	            return q1.peek();
	        }else{
	            return q2.peek();
	        }
	    }
	    
	    public boolean empty() {
	        return q1.isEmpty() && q2.isEmpty();
	    }
	}
}
