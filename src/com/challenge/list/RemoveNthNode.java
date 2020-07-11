package com.challenge.list;

public class RemoveNthNode {
	
	public static void main(String args[]) {
		System.out.println("Test");
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		
		RemoveNthNode r = new RemoveNthNode();
		
		ListNode f = r.removeNthNode(l1, 2);
		
		while(f!=null) {
			System.out.println(f.val);
			f = f.next;
		}
		
		
	}

	private ListNode removeNthNode(ListNode l1, int N) {
		int i =0;
		
		ListNode dummyHead = l1;
		
		while (l1.next!=null) {
			i++;
			if(i+1 == N) {
				l1.next = l1.next.next;
				break;
			}
			l1 = l1.next;
		}
		return dummyHead;
	}

}
