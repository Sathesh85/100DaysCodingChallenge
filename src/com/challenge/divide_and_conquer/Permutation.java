package com.challenge.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	List<List<Integer>> permute(int[] nums, int idx){
        List<List<Integer>> masterList = new ArrayList<>();
        if(idx < 0){
            masterList.add(new ArrayList<>());
        } else {
        	int rem = nums[idx];
            List<List<Integer>> moreSubset = permute(nums, idx-1);
            
            for(List<Integer> subSet : moreSubset){
                List<List<Integer>> moreSet = new ArrayList<>();
                for(int i =0; i<=subSet.size();i++){
                	moreSet.add(createList(i,rem, subSet));
                }
                masterList.addAll(moreSet);
            }
            
        }
        
        return masterList;
    }
    
    List<Integer> createList(int idx, int val, List<Integer> sub){
        List<Integer> list = new ArrayList<>();
        list.addAll(sub.subList(0,idx));
        list.add(val);
        if(sub.size()>idx)
        list.addAll(sub.subList(idx,sub.size()));
        return list;
    }

}
