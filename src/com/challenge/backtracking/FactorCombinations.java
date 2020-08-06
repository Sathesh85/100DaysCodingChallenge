package com.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	
	public static void main(String[] args) {
		FactorCombinations c = new FactorCombinations();
		
		System.out.println(c.getFactors(1));
	}

	public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> subResult = new ArrayList<>();
        
        helper(n, result, subResult, 2, n);
        
        return result;
    }

	void helper(int n, List<List<Integer>> result, List<Integer> subResult, int factor, int max){
		
		if(factor == max){
            return;
        }
		
		if(n==1){
            result.add(new ArrayList<>(subResult));
            return;
        }
		
		
        
        for(int i=factor; i<=n; i++) {
        	
        	
            
        
        	if(n%i == 0) {
        		subResult.add(i);
        		helper(n/i, result, subResult, i,max);
        		subResult.remove(new Integer(i));
        	}
        }
        
        
    }

}
