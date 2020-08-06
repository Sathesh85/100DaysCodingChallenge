package com.challenge.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationProblem {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<Integer>(), result);
        
        return result;
        
    }
    
    void combinationSum(int[] candidates, int target, List<Integer> subList, List<List<Integer>> result) {
        
        if(target<0){
            return;
        }
        
        if(target == 0){
            result.add(new ArrayList<>(subList));
            return;
        }
        
        for(int i=0; i< candidates.length;i++){
            if(subList.size()>0 &&subList.get(subList.size()-1) < candidates[i]){
                return;
            }
            subList.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], subList, result);
            subList.remove(subList.size()-1);
        }
    }

}
