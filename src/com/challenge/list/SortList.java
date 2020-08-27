package com.challenge.list;

public class SortList {
	
	public static void main(String[] args) {
		SortList r = new SortList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		ListNode res = r.sortList(head);
		System.out.println(res);
	}
	
	ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode fast = head, slow = head, prev = null;
		
		while(fast!=null && fast.next!=null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		prev.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		
		return merge(left, right);
		
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode merge = new ListNode(0);
		ListNode curr = merge;
		
		while(left!= null && right != null) {
			if(left.val< right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		
		if(left!=null) {
			curr.next = left;
		}
		
		if(right!=null) {
			curr.next = right;
		}
		
		return merge.next;
	}

}
