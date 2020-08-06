package com.challenge.list;

public class FlattenLinkedList {
	
	public static void main(String[] args) {
		
	}
	
	
	 public Node flatten(Node head) {
		 if (head == null) return head;
	        Node temp = new Node(0);
	        temp.next = head;
	        flattenGetTail(head,temp);
	        temp.next.prev = null;
	        return temp.next;
	        
	        
	    }
	    public Node flattenGetTail(Node prev, Node curr){  
	    	if(curr == null) {
	    		return prev;
	    	}
	    	
	    	curr.prev =prev;
	    	prev.next = curr;
	    	
	    	Node tempNext = curr.next;
	    	
	    	Node tail = flattenGetTail(curr, curr.child);
	    	
	    	curr.child = null;
	    	
	    	return flattenGetTail(tail, tempNext);
	     
	    }

}

class Node{
	public int val;
    public Node prev;
    public Node next;
    public Node child;
    
    Node(int val){
    	this.val = val;
    }
	
}
