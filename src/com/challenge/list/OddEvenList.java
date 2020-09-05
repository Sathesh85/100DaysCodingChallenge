package com.challenge.list;

public class OddEvenList {
	
	public static void main(String[] args) {
		OddEvenList o = new OddEvenList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode res = o.arrangeList(head);
		System.out.println(res);
	}

	/**
	 * @param head
	 * @return
	 * 
	 * Arrange list using extra variables
	 */
	private ListNode arrangeList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode odd = new ListNode(0);
		ListNode even = new ListNode(0);
		ListNode currOdd = odd;
		ListNode currEven = even;
		
		int i=1;
		
		while(head!=null) {
			if(i%2==0) {
				even.next = head;
				even = even.next;
			} else {
				odd.next = head;
				odd = odd.next;
			}
			i++;
			head = head.next;
		}
		odd.next = currEven.next;
		even.next = null;
		
		return currOdd.next;
	}
	
	/*
	 * without extra spaces
	 */
	private ListNode arrangeListWithoutExtraSpace(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode odd = head, even = head.next, evenHead = head;
		
		while(even !=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		
		return head;
	}

}
