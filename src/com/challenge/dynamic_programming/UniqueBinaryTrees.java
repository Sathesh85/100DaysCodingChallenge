package com.challenge.dynamic_programming;

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
	
	public static void main(String[] args) {
		UniqueBinaryTrees t = new UniqueBinaryTrees();
		
		int count = t.countUniqueBinaryTrees(3);
		System.out.println(count);
	}

}
