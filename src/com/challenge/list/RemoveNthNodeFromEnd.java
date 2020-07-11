package com.challenge.list;

public class RemoveNthNodeFromEnd {
	
	public static void main(String args[]) {
		System.out.println("Test");
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
		
		ListNode f = r.removeNthNodeFromEnd(l1, 2);
		
		while(f!=null) {
			System.out.println(f.val);
			f = f.next;
		}
		
		
	}

	private ListNode removeNthNodeFromEnd(ListNode l1, int N) {
		
		ListNode temp = new ListNode(0);
        temp.next = l1;
		ListNode fp= temp;
		ListNode sp = temp;
		for(int i = 0 ; i< N; i++ ) {
			fp = fp.next;
		}
		
		while(fp.next!=null) {
			fp = fp.next;
			sp = sp.next;
		}
		sp.next = sp.next.next;
		return temp.next;
	}

}
