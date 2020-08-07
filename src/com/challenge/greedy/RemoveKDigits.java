package com.challenge.greedy;

public class RemoveKDigits {
	
	public static void main(String[] args) {
		RemoveKDigits r = new RemoveKDigits();
		System.out.println(r.removeKdigits("1432219", 3));
	}
	
	  int min = Integer.MAX_VALUE;
	    

	/**
	 * @param num
	 * @param k
	 * @return
	 * 
	 * Time limit exceeding
	 * 
	 * 
	 */
	String removeKdigits(String num, int k) {
	        
	        if(num.length()<= k){
	            return "0";
	        }
	        
	        
	        removeKdigitsHelper(num, k);
	        return String.valueOf(min);
	        
	    }
	    
	    void removeKdigitsHelper(String num, int k){
	        if(k==0){
	        	min = Math.min(Integer.valueOf(num), min);
	            return;
	        }
	        
	        for(int i=0; i<num.length();i++){
	            removeKdigitsHelper(num.substring(0,i) + num.substring(i+1), k-1);
	        }
	        
	    } 

}
