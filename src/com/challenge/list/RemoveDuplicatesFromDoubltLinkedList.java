package com.challenge.list;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromDoubltLinkedList {
	public static void main(String[] args) {
		Node list = new Node(2);
		Node head = list;
		list.prev = null;
		Node next = new Node(3);
		list.next = next;
		
		next.prev = list;
		list = next;
		next = new Node(2);
		list.next = next;
		
		
		RemoveDuplicatesFromDoubltLinkedList l = new RemoveDuplicatesFromDoubltLinkedList();
		
		/*Node res = l.removeDuplicates(head);
		System.out.println(res);*/
		Node res = l.removeDuplicatesUnSorted(head);
		System.out.println(res);
	}

	/**
	 * @param head
	 * @return
	 * Remove duplicates of sorted list
	 * 
	 */
	private Node removeDuplicates(Node head) {
		
		Node curr = head;
		Node next = head.next;
		
		while(next!= null) {
			while(next != null && curr.val == next.val) {
				next = next.next;
			}
			
			curr.next = next;
			if(next!=null) next.prev = curr;
			curr = next;
		}
		
		return head;
		
		
	}
	
	
	/**
	 * @param head
	 * @return
	 * 
	 * Removed duplicates for an unsorted list
	 * Time O(n)
	 * Space O(n)
	 */
	private Node removeDuplicatesUnSorted(Node head) {
		
		Set<Integer> set = new HashSet<>();
		Node curr = head;
		Node next = curr.next;
		set.add(head.val);
		
		while(next!=null) {
			if(set.contains(next.val)) {
				next = next.next;
				curr.next = next;
			} else {
				set.add(next.val);
				curr.next = next;
				next.prev = curr;
				curr = next;
				next = curr.next;
			}
		}
		
		
		return head;
	}
	
	private Node removeDuplicatesWithoutAuxSpace(Node head) {
		
		Node curr = sort(head);
		
		
		return curr;
	}

	private Node sort(Node head) {
		
		return null;
	}

}
