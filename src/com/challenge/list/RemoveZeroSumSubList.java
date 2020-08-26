package com.challenge.list;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSubList {
	
	public static void main(String[] args) {
		RemoveZeroSumSubList r = new RemoveZeroSumSubList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(-2);
		head.next.next = new ListNode(1);
		ListNode res = r.removeZeroSumSublists(head);
		System.out.println(res);
		
	}
	
	public ListNode removeZeroSumSublists(ListNode head) {
		
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		dummy.next = head;
		
		int prefix =0;
		Map<Integer, ListNode> m = new HashMap<>();
		
		while(curr!=null) {
			prefix += curr.val;
			if(m.containsKey(prefix)) {
				curr = m.get(prefix).next;
				int p = prefix + curr.val;
				while(p!=prefix) {
					m.remove(p);
                    curr = curr.next;
                    p += curr.val;
				}
				m.get(prefix).next = curr.next;
			} else {
				m.put(prefix, curr);
			}
			
			curr = curr.next;
		}
		
		return dummy.next;
		
	}

}
