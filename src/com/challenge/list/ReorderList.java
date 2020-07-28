package com.challenge.list;

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		ReorderList r = new ReorderList();
		r.reorderList(l1);
	}
	
	 public void reorderList(ListNode head) {
	        
	        //Find Middle
	        ListNode fast = head;
	        ListNode slow = head;
	        
	        while(fast!=null && fast.next != null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        
	        ListNode middle = slow;
	        
	        ListNode second = reverseList(middle);
	        ListNode first = head;
	        //Merge first and secong
	        
	        while(first!=null && second!=null){
	            ListNode ftemp = first.next;
	            ListNode stemp = second.next;
	            first.next = second;
	            second.next = ftemp;
	            second = stemp;
	            first = ftemp;
	        }
//	        second.next = null;
	        if(first != null)
	        	first.next = second !=null ? second.next : second;
	        
	    }
	    
	    private ListNode reverseList(ListNode head){
	        ListNode prev = null;
	        ListNode curr = head;
	        ListNode next = head.next;
	        
	        while(next!=null){
	            curr.next = prev;
	            prev = curr;
	            curr = next; 
	            next = curr.next;
	        }
	        curr.next = prev;
	        
	        return curr;
	    }

}
