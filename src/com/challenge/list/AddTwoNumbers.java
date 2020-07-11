package com.challenge.list;

public class AddTwoNumbers {
	
	public static void main(String args[]) {
		System.out.println("Test");
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(9);
		
		AddTwoNumbers n = new AddTwoNumbers();
		ListNode f = n.addTwoNumbers(l1, l2);
		
		while(f!=null) {
			System.out.println(f.val);
			f = f.next;
		}
		
	}
	
	
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	
	    	l1 = reverseList(l1);
	    	l2 = reverseList(l2);
	    	
	    	ListNode dummyHead = new ListNode(0);
	    	ListNode f = dummyHead;
	    	int rem = 0;
	    	
	    	while(l1 !=null && l2 !=null) {
	    		int val = l1.val + l2.val + rem;
	    		
	    		rem = 0;
	    		
	    		if(val/10==1) {
	    			rem = 1;
	    			f.next = new ListNode(val%10);
	    		} else {
	    			f.next = new ListNode(val);
	    		}
	    		f = f.next;
	    		l1 = l1.next;
	    		l2 = l2.next;
	    				
	    	}
	    	
	    	while(l1!=null) {
	    		int val = l1.val + rem;
	    		rem = 0;
	    		if(val/10==1) {
	    			rem = 1;
	    			f.next = new ListNode(val%10);
	    		} else {
	    			f.next = new ListNode(val);
	    		}
	    		f = f.next;
	    		l1 = l1.next;
	    	}
	    	
	    	while(l2!=null) {
	    		int val = l2.val + rem;
	    		rem = 0;
	    		if(val/10==1) {
	    			rem = 1;
	    			f.next = new ListNode(val%10);
	    		} else {
	    			f.next = new ListNode(val);
	    		}
	    		f = f.next;
	    		l2 = l2.next;
	    	}
	    	
	    	if(rem>0) {
	    		f.next = new ListNode(rem);
	    	}

	    	return reverseList(dummyHead.next);
	        
	    }

		private ListNode reverseList(ListNode l1) {
			if(l1 == null) {
				return null;
			}
			
			ListNode prev = null;
			ListNode curr = l1;
			ListNode next = null;
			
			while(curr!=null) {
				
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				
				
			}
			return prev;
		}
}
