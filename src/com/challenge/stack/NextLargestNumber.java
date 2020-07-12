package com.challenge.stack;

import java.util.Stack;

public class NextLargestNumber {
	
	/*
	 * 1 3 2 4
	 * 
	 * 1 
	 * 
	 * 
	 * O(n^2);
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String args[]) {
		NextLargestNumber n = new NextLargestNumber();
		int arr[] = {1,3,2,4};
		n.findNextLargestNumber(arr);
		
		int arr1[] = {4,3,2,1};
		n.findNextLargestNumber(arr1);
	}
	
	
	/*
	 * Solved using n^2
	 * 
	 * 
	 */
	private void findNextLargestNumber(int arr[]) {
		
		for(int i =0; i< arr.length; i++) {
			boolean found = false;
			for(int j = i+1; j < arr.length ; j++) {
				if(arr[i] < arr[j]) {
					System.out.println(arr[i] + "<" + arr[j]);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println(arr[i] + "<" +-1);
			}
		}
		
		
	}
	
	private void findNextLargetNumberOptimized(int arr[]) {
		Stack<Integer> s = new Stack<>();
		s.add(arr[0]);
		for(int a : arr) {
			if(a>s.peek()) {
				s.add(a);
			}
		}
		
		/*
		 * 1 3 2 4
		 * 
		 *  4 3 1 
		 * 
		 */
		
		for(int i = arr.length-1; i>=0; i--) {
			if(arr[i] > s.peek()) {
				System.out.println(arr[i] + "<" + s.peek());
			} else if(arr[i] == s.peek()){ 
				s.pop();
			}else {
				System.out.println(arr[i] + "<" + -1);
			}
		}
		
		
	}
	
	

}
