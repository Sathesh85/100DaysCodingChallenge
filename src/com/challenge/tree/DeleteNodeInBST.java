package com.challenge.tree;

public class DeleteNodeInBST {
	
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.right = new Node(2);
		
		DeleteNodeInBST d = new DeleteNodeInBST();
		Node res = d.deleteNode(root, 2);
		System.out.println(res);
		
	}
	boolean found = false;

	public Node deleteNode(Node root, int key) {
		
		if(root == null) {
			return null;
		}
		
		if(root.data == key) {
			if(root.left !=null) {
				Node temp = predecessor(root);
				root.data = temp.data;
				root.left = deleteNode(root.left, temp.data);
			} else if(root.right != null) {
				Node temp = successor(root);
				root.data = temp.data;
				root.right = deleteNode(root.right, temp.data);
			} else {
				root = null;
			}
			return root;
		}
		
		
		if(root.data > key) {
			root.left = deleteNode(root.left, key);
		} else {
			root.right = deleteNode(root.right, key);
		}
		
		return root;

	}

	private Node successor(Node root) {
		root = root.right;
		while(root.left!=null) root = root.left;
		return root;
	}

	private Node predecessor(Node root) {
		root = root.left;
		while(root.right!=null) root = root.right;
		return root;
	}

}
