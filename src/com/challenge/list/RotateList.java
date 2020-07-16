package com.challenge.list;

public class RotateList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		
		RotateList r = new RotateList();
		
		
		ListNode resNode = r.rotateRight(l1, 5);
		System.out.println(resNode);
		
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		
		//Edge cases
		
		if(head == null || k == 0) {
			return head;
		}
		
		//Find the length of the list
		
		int count = 0;
		ListNode curr = head;
		while(curr != null) {
			count ++;
			curr = curr.next;
		}
		//Do a modulo operation with the k
		
		k = k % count;
		
		
		//Use fast runner and slow runner approach
		count = 0;
		
		ListNode fNode = head, sNode = head;
		
		while(fNode.next!=null) {
			fNode = fNode.next;
			
			if(count>=k) {
				sNode = sNode.next;
			}
			count ++;
		}
		
		//change the pointers
		fNode.next = head;
		head = sNode.next;
		sNode.next = null;
		
		
        
		return head;
    }

}
