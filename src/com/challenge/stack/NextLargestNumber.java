package com.challenge.stack;

import java.util.Arrays;
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
		int arr[] = { 1, 3, 2, 4 };
		n.findNextLargestNumber(arr);
		n.findNextLargetNumberOptimized(arr);
		

		int arr1[] = { 4, 3, 2, 1 };
		n.findNextLargestNumber(arr1);
		n.findNextLargetNumberOptimized(arr1);
	}

	/*
	 * Solved using n^2
	 * 
	 * 
	 */
	private void findNextLargestNumber(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			boolean found = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					System.out.println(arr[i] + "<" + arr[j]);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println(arr[i] + "<" + -1);
			}
		}
	}

	private void findNextLargetNumberOptimized(int arr[]) {
		int res[] = new int[arr.length];
		Arrays.fill(res, -1);
		
		Stack<Integer> s = new Stack<>();
		
		for(int i =0 ; i < arr.length; i++) {
			
			while (!s.isEmpty() && arr[i]> arr[s.peek()]) {
				res[s.pop()] = arr[i];
			}
			s.push(i);
		}
		
		for( int i =0 ; i < arr.length; i++) {
			System.out.println(arr[i] +" next greatest element is " + res[i]);
		}
		
	}

}
