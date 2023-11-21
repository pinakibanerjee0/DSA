package com.pinaki.LinkedList;

import com.pinaki.LinkedList.ReverseLinkedList.ListNode;

public class MergeTwoSortedList {
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				list1.next = mergeTwoLists(list1.next, list2);
				return list1;
			} else {
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}
		if (list1 == null)
			return list2;
		return list1;

	}

	public static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
		// Create a dummy node to serve as the head of the merged list
		ListNode head = new ListNode(0);
		ListNode current = head;

		// Iterate through both lists until one of them becomes null
		while (list1 != null && list2 != null) {
			// Compare the values of the nodes and append the smaller value to the merged
			// list
			if (list1.val <= list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}

		// Append the remaining nodes of the non-null list to the merged list
		if (list1 != null) {
			current.next = list1;
		} else {
			current.next = list2;
		}

		// Return the head of the merged list (excluding the dummy node)
		return head.next;
	}

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
		System.out.println("after merge linked list is ");

		while (mergeTwoLists != null) {
			System.out.print(mergeTwoLists.val + " , ");
			mergeTwoLists = mergeTwoLists.next;
		}
	}
}
