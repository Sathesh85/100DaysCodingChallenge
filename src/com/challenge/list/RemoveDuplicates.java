package com.challenge.list;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		
		ListNode l = new ListNode(1);
		l.next = new ListNode(1);/*
		l.next.next = new ListNode(2);
		l.next.next.next = new ListNode(2);
		l.next.next.next.next = new ListNode(3);*/
		
		ListNode res = r.removeDup(l);
		System.out.println(res);
	}

	private ListNode removeDup(ListNode head) {
        ListNode dup = new ListNode(0);
        ListNode tempDup = dup;
        while(head!=null && head.next !=null){
            if(head.val != head.next.val){
            	dup.next = head;
            	dup = dup.next;
            	head = head.next;
            } else {
            	while(head.next!=null && head.val == head.next.val) {
            		head = head.next;
            	}
            	head = head.next;
            }
            
        }
        dup.next = head;
        return tempDup.next;
		
	}
	
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode dup = new ListNode(0);
	        ListNode tempDup = dup;
	        
	        while(head!=null && head.next !=null){
	            if(head.val != head.next.val){
	                dup.next = head;
	                dup = dup.next;
	                head = head.next;
	            } else {
	                dup.next = head;
	                dup = dup.next;
	                while(head!=null && head.next!=null && head.val == head.next.val){
	                    head = head.next;
	                }
	                head = head.next;
	            }
	        }
	        
	        dup.next = head;
	        return tempDup.next;
	        
	    }

}
