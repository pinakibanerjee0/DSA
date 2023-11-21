package com.pinaki.LinkedList;

import com.pinaki.LinkedList.ReverseLinkedList.ListNode;

public class Practice {

	
	// Driver Code
		public static void main(String[] args) {
			ListNode list = new ListNode(5);
			list.next = new ListNode(10);
			list.next.next = new ListNode(14);
			list.next.next.next = new ListNode(20);

			ListNode list2 = new ListNode(5);
			list2.next = new ListNode(6);
			list2.next.next = new ListNode(16);
			list2.next.next.next = new ListNode(29);

			ListNode mergeTwoLists = mergeTwoListsIterative(list, list2);
			list = middleNode(mergeTwoLists);
			ListNode reverseList = reverseList(list2);

			System.out.println("after merge linked list is ");

			while (mergeTwoLists != null) {
				System.out.print(mergeTwoLists.val + " , ");
				mergeTwoLists = mergeTwoLists.next;
			}
			
			System.out.println("");
			System.out.println("middle of linked list ");
			
			while(list!=null) {
				System.out.print(list.val+" , ");
				list=list.next;
			}
			
			System.out.println("");
			System.out.println("Reversed linked list ");
			
			while(reverseList!=null) {
				System.out.print(reverseList.val+" , ");
				reverseList=reverseList.next;
			}
		}

		private static ListNode reverseList(ListNode head) {
			if(head==null || head.next==null) return head;		
			ListNode prev = null;

			while(head!=null) {
				ListNode next = head.next;
				head.next = prev;
				prev = head;
				head = next;
			}


			return prev;
		}

	private static ListNode middleNode(ListNode list) {
		if(list==null || list.next==null) return list;
		ListNode slow = list;
		ListNode fast = list;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			//list = list.next;
		}

		return slow;
	}

	private static ListNode mergeTwoListsIterative(ListNode list, ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		while(list!=null && list2!=null) {
			if(list.val<=list2.val) {
				current.next = list;
				list = list.next;
			}else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}
		
		while(list!=null) {
			current.next = list;
			list = list.next;
			current = current.next;
		}
		
		while(list2!=null) {
			current.next = list2;
			list2 = list2.next;
			current = current.next;
		}
		
		return head.next;
	}
}
