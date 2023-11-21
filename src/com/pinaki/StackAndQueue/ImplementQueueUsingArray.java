package com.pinaki.StackAndQueue;

public class ImplementQueueUsingArray {

	public static void main(String[] args) {
		  Queue q = new Queue(6);
	        q.add(4);
	        q.add(14);
	        q.add(24);
	        q.add(34);
	        System.out.println("The peek of the queue before deleting any element " + q.peek());
	        System.out.println("The size of the queue before deletion " + q.size());
	        System.out.println("The first element to be deleted " + q.remove());
	        System.out.println("The peek of the queue after deleting an element " + q.peek());
	        System.out.println("The size of the queue after deleting an element " + q.size());
	    
	}

	public static class Queue {
		int[] arr;
		int peek, end, size, capacity;

		Queue(int capacity) {
			this.capacity = capacity;
			arr = new int[capacity];
			peek = -1;
			end = -1;
			size = end + 1;
		}

		void add(int newElement) {
			if (size == capacity) {
				System.out.println("Queue is full\nExiting...");
				System.exit(1);
			} else if (end == -1) {
				peek = 0;
				end = 0;
			} else
				end = (end + 1) % capacity;

			arr[end] = newElement;
			System.out.println("The element added is " + newElement);
			size++;
		}

		int remove() {
			if (size == 0) {
				System.out.println("Queue is empty \nExiting...");
				System.exit(1);
			}
			int x = arr[peek];
			if (end == -1) {

				peek = 0;
				end = 0;
			}
			peek = (peek + 1) % capacity;
			size--;
			return x;
		}

		int peek() {
			if (size == 0)
				return -1;
			return arr[peek];
		}

		int size() {
			return size;
		}
	}
}
