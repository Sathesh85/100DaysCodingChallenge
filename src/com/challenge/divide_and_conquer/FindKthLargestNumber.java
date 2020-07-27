package com.challenge.divide_and_conquer;

import java.util.PriorityQueue;

public class FindKthLargestNumber {
	
	public static void main(String[] args) {
		FindKthLargestNumber f = new FindKthLargestNumber();
		int[] nums = {3,2,5,1};
		int res = f.findKthLargest(nums, 2);
		System.out.println(res);
		
	}
	
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0; i< k;i++) {
        	queue.add(nums[i]);
        }
        
        for(int i =k; i< nums.length ;i++) {
        	if(queue.peek() < nums[i]) {
        		queue.poll();
        		queue.add(nums[i]);
        	}
        }
        
        return queue.peek();
    }
	
	
}
