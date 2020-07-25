package com.challenge.system_design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BrowsingHistory {
	
	public static void main(String[] args) {
		BrowsingHistory h = new BrowsingHistory("google.com");
		System.out.println(h.back(1));
		h.visit("youtube.com");
		h.visit("linkedin.com");
		h.visit("leetcode.com");
		System.out.println(h.back(1));
		System.out.println(h.forward(2));
		h.visit("twitter.com");
		System.out.println(h.back(10));
		System.out.println(h.forward(10));
		int[] nums = {1,2,3};
		
		System.out.println(h.permute(nums));
	}
    
    Stack<String> s1,s2;

    public BrowsingHistory(String homepage) {
    	s1 = new Stack<>();
    	s2 = new Stack<>();
        s1.push(homepage);
    }
    
    public void visit(String url) {
        s1.push(url);
        while(!s2.isEmpty()) { s2.pop();}
    }
    
    public String back(int steps) {
        while(steps-- >1 && s1.size()>1) {
        	s2.push(s1.pop());
        }
        return s1.peek();
    }
    
    public String forward(int steps) {
    	 while(steps-- >0 && !s2.isEmpty()) {
         	s1.push(s2.pop());
         }
    	 return (!s1.isEmpty()) ? s1.peek() : s2.peek();
        
    }
    
 public List<List<Integer>> permute(int[] nums) {
        
        return permute(nums,nums.length-1);
        
    }
    
    List<List<Integer>> permute(int[] nums, int idx){
        List<List<Integer>> masterList = new ArrayList<>();
        if(idx < 0){
            masterList.add(new ArrayList<>());
        } else {
        	int rem = nums[idx];
            List<List<Integer>> moreSubset = permute(nums, idx-1);
            
            for(List<Integer> subSet : moreSubset){
                List<List<Integer>> moreSet = new ArrayList<>();
                for(int i =0; i<=subSet.size();i++){
                	moreSet.add(createList(i,rem, subSet));
                }
                masterList.addAll(moreSet);
            }
            
        }
        
        return masterList;
    }
    
    List<Integer> createList(int idx, int val, List<Integer> sub){
        List<Integer> list = new ArrayList<>();
        list.addAll(sub.subList(0,idx));
        list.add(val);
        if(sub.size()>idx)
        list.addAll(sub.subList(idx,sub.size()));
        return list;
    }
}