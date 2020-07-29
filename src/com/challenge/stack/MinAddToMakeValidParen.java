package com.challenge.stack;

import java.util.Stack;

public class MinAddToMakeValidParen {
	
	 public int minAddToMakeValid(String S) {
	        
	        Stack<Character> stack = new Stack<>();
	        int count = 0;
	        for(char c : S.toCharArray()){
	            if(c == '('){
	                stack.push('(');
	            } else {
	                if(stack.isEmpty()){
	                    count ++;
	                } else {
	                    stack.pop();
	                }
	                
	            }
	        }
	        
	        count += stack.size();
	        return count;
	        
	        /*
	         * Without using stack
	         */
	        
	       /* int count = 0;
	        int sCount = 0;
	        for(char c : S.toCharArray()){
	            if(c == '('){
	                sCount++;
	            } else {
	                if(sCount==0){
	                    count ++;
	                } else {
	                    sCount--;
	                }
	                
	            }
	        }
	        
	        count += sCount;
	        return count;*/
	        
	    }

}
