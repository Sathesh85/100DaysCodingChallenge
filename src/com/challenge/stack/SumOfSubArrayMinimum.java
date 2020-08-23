package com.challenge.stack;

public class SumOfSubArrayMinimum {
	
	public int sumSubarrayMins(int[] A) {
        int totalMin = 0;
        for(int i=0; i< A.length; i++){
            
            for(int j=0; j+i< A.length; j++){
                int sub = i+1;
                int min = Integer.MAX_VALUE;
                int k = j;
                System.out.println(sub);
                while(sub>0){
                    min = Math.min(min, A[k++]);
                    sub--;
                }
                if(min!=Integer.MAX_VALUE)
                    totalMin += min;
            }
        }
        return totalMin;
    }

}
