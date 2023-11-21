package com.pinaki.LinkedList;

/*
 * 
 * Given the head of a singly linked list, write a program to reverse the linked list,
 *  and return the head pointer to the reversed list.

Examples:

Input Format: 
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.

Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10.
 */
public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	// Driver Code
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.val = 85;
		list.next = new ListNode(15);
		list.next.next = new ListNode(4);
		list.next.next.next = new ListNode(20);

		System.out.println("Given linked list");
		System.out.println("85 , 15 , 4 , 20");
		list = reverseList(list);
		System.out.println("");
		System.out.println("Reversed linked list ");
		
		while(list!=null) {
			System.out.print(list.val+" , ");
			list=list.next;
		}
	}
}
