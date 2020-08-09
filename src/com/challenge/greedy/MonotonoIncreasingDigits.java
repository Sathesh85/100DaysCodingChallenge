package com.challenge.greedy;

public class MonotonoIncreasingDigits {
	
	public static void main(String[] args) {
		MonotonoIncreasingDigits d = new MonotonoIncreasingDigits();
		d.monotoneIncreasingDigits(33311);
	}
	
	 public int monotoneIncreasingDigits(int N) {
	        char[] s = String.valueOf(N).toCharArray();
	        int i=1;
	        while(i<s.length && s[i-1]<= s[i] ) i++;
	        while(0<i && i<s.length && s[i-1]>s[i]) { 
	        	s[--i]--; }
	        
	        for(int j=i+1; j<s.length; ++j) {
	        	s[j]='9';}
	        
	        return Integer.parseInt(String.valueOf(s));
	        
	    }

}
