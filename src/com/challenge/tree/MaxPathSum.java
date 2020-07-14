package com.challenge.tree;

public class MaxPathSum {
	
	int max = Integer.MIN_VALUE;
	
	/*
	 * Path has negative value
	 */

	public int maxPathSum(Node root) {
		
		if(root == null)
			return 0;
		
		int lSum = Math.max(maxPathSum(root.left),0);
		
		int rSum = Math.max(maxPathSum(root.right),0);
		
		int totalSum = lSum + rSum + root.data;
		
		max = Math.max(max, totalSum);
		
		return root.data + Math.max(lSum, rSum);
		
	}

}
