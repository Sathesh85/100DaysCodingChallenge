package com.challenge.priority_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPair {
	
	public static void main(String[] args) {
		KSmallestPair k = new KSmallestPair();
		
		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3};
		k.kSmallestPairs(nums1, nums2, 10);
	}
	
	 public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        PriorityQueue<int[]> queue = 
	        		new PriorityQueue<>((o2,o1) ->Integer.compare(o1[0]+o1[1], o2[0]+o2[1]) );
	        
	        int count = 0;
	        
	        for(int a : nums1){
	            for(int b : nums2){
	                if(count < k){
	                    queue.offer(new int[]{a,b});
	                    count ++;
	                }
	                
	                else if(queue.peek()[0] + queue.peek()[1] > a+b){
	                    queue.poll();
	                    queue.offer(new int[]{a,b});
	                }
	            }
	        }
	        List<List<Integer>> res = new ArrayList<>();
	        
	        for(int[] a : queue){
	        	res.add(Arrays.asList(a[0],a[1]));
	        }
	        
	        return res;
	    }
	

}
