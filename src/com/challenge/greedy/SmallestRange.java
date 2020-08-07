package com.challenge.greedy;

import java.util.Arrays;

public class SmallestRange {
	
	 public int smallestRangeII(int[] A, int k) {
	        
	        Arrays.sort(A);
	        
	        int n = A.length;
	        int res = A[n-1] - A[0];
	        
	        for(int i=0; i< n-1; i++){
	            int max = Math.max(A[i]+k, A[n-1]-k);
	            int min = Math.min(A[0]+k, A[i+1]-k);
	            res = Math.min(res, max-min);
	        }
	        
	        return res;
	    }

}
