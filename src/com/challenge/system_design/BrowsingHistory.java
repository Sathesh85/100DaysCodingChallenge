package com.challenge.system_design;

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
        while(steps-- >0 && !s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        return (!s1.isEmpty()) ? s1.peek() : s2.peek();
    }
    
    public String forward(int steps) {
    	 while(steps-- >0 && !s2.isEmpty()) {
         	s1.push(s2.pop());
         }
    	 return (!s1.isEmpty()) ? s1.peek() : s2.peek();
        
    }
}