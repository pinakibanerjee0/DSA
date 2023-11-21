package com.pinaki.LinkedList;

import com.pinaki.LinkedList.ReverseLinkedList.ListNode;

public class MiddleOfTheLinkedList {

	public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
       
        ListNode fast = head;
     
        while(fast!=null && fast.next!=null ){
            head = head.next;
            fast = fast.next.next;
        }
       
        return head;
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
		list = middleNode(list);
		System.out.println("");
		System.out.println("after middle linked list ");
		
		while(list!=null) {
			System.out.print(list.val+" , ");
			list=list.next;
		}
	}
}
