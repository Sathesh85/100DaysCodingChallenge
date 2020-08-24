package com.challenge.stack;

import java.util.Stack;

public class SumOfSubArrayMinimum {
	
	public static void main(String[] args) {
		SumOfSubArrayMinimum s = new SumOfSubArrayMinimum();
		int A[] = {3,1,2,4};
		int res = s.sumSubarrayMins(A);
		System.out.println(res);
	}
	
	/*public int sumSubarrayMins(int[] A) {
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
    }*/

	 public int sumSubarrayMins(int[] A) {
	        int MOD = 1_000_000_007;

	        Stack<RepInteger> stack = new Stack<>();
	        int ans = 0, dot = 0;
	        for (int j = 0; j < A.length; ++j) {
	            // Add all answers for subarrays [i, j], i <= j
	            int count = 1;
	            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
	                RepInteger node = stack.pop();
	                count += node.count;
	                dot -= node.val * node.count;
	            }
	            stack.push(new RepInteger(A[j], count));
	            dot += A[j] * count;
	            ans += dot;
	            ans %= MOD;
	        }

	        return ans;
	    }
	}

	class RepInteger {
	    int val, count;
	    RepInteger(int v, int c) {
	        val = v;
	        count = c;
	    }
	}
