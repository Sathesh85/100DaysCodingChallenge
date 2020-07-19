package com.challenge.dynamic_programming;

import java.util.ArrayList;
import java.util.List;


public class UniqueBinaryTrees {
	
	private int countUniqueBinaryTrees(int n) {
		
		int[] mem = new int[n+1];
		
		mem[0] = 1; mem[1]= 1;
		
		for(int i=2; i<= n; ++i) {
			for(int j=1;j<=i; ++j) {
				mem[i] += mem[j-1] * mem[i-j];
			}
		}
		
		return mem[n];
		
		
	}
	
	private List<Node> createUniqueBinaryTree(int start, int end){
		List<Node> list = new ArrayList<Node>();
		if(start>end) {
			list.add(null);
			return list;
		}
		
		for(int i= start; i <= end; i++) {
			List<Node> leftList = createUniqueBinaryTree(start, i-1);
			List<Node> rightList = createUniqueBinaryTree(i+1, end);
			
			for(Node left: leftList) {
				for(Node right: rightList) {
					Node root = new Node(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		UniqueBinaryTrees t = new UniqueBinaryTrees();
		
		int count = t.countUniqueBinaryTrees(3);
		System.out.println(count);
		
		List<Node> list = t.createUniqueBinaryTree(1, 3);
		System.out.println(list);
	}

}
