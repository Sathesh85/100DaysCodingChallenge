package com.challenge.list;

import com.challenge.tree.Node;

public class LinkedListInBinarySearchTree {
	
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.left.right = new Node(4);
		
		LinkedListInBinarySearchTree b = new LinkedListInBinarySearchTree();
		boolean res = b.isSubPath(l, root);
		System.out.println(res);
	}

	public boolean isSubPath(ListNode head, Node root) {
		if(root == null) {
			return false;
		}
		
		if(root.data == head.val ) {
			if(checkIfDownWard(root, head)) {
				return true;
			}
		}
		
		
		return isSubPath(head, root.left) || isSubPath(head, root.right);

	}

	private boolean checkIfDownWard(Node root, ListNode head) {
		if(head == null) {
			return true;
		}
		
		if(root == null) {
			return false;
		}
		
		if(head.val == root.data) {
			return checkIfDownWard(root.left, head.next) || checkIfDownWard(root.right, head.next);
		}
		
		return false;
	}

}
