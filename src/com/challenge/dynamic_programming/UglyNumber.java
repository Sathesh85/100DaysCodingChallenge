package com.challenge.dynamic_programming;

import java.util.PriorityQueue;

public class UglyNumber {
	
	/**
	 * 
	 * Using Dynamic programming
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumberByDP(int n) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[0]+o1[1] - o2[0]+o2[1] );
		queue.add(new int[]{1,2});
        int idx = 1;
        int uglyArr[] = new int[n];
        uglyArr[0] = 1;
        int i2 =0, i3 = 0, i5 =0;
        
        while(idx != n){
            
            int val = Math.min(uglyArr[i2]*2 , Math.min( uglyArr[i3] *3, uglyArr[i5] * 5));
            uglyArr[idx++] = val;
            
            if(uglyArr[i2]*2 == val){
                i2++;
            }
            if(uglyArr[i3]*3 == val){
                i3++;
            }
            if(uglyArr[i5]*5 == val){
                i5++;
            }
            
        }
        
        return uglyArr[n-1];
        
    }
	
	
	 /**
	  * 
	  * Solving using direct method. 
	  * But will take more time for a bigger number
	  * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
	        
	        if(n<1){
	            return 0;
	        }
	        
	        int count = 1;
	        int idx = 1; 
	        while(count != n){
	            idx ++;
	            if(isUgly(idx)){
	                count ++;
	            }
	        }
	        return idx;
	        
	    }
	    
	    private boolean isUgly(int val){
	        
	        val = maxDivide(val, 2);
	        val = maxDivide(val, 3);
	        val = maxDivide(val, 5);
	        
	        return (val == 1);
	        
	    }
	    
	    private int maxDivide(int a, int b){
	        while(a%b ==0){
	            a = a/b;
	        }
	        return a;
	    }
	
	

}
