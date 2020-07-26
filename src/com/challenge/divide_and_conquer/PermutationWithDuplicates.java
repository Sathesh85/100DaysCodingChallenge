package com.challenge.divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicates {
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		PermutationWithDuplicates p = new PermutationWithDuplicates();
		System.out.println(p.permuteUnique(nums));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		dfs(nums,res, visited, list);
		return res;
	}

	private void dfs(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> list) {
		if(nums.length == list.size()) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for(int i =0 ; i < nums.length ; i++) {
			if(visited[i]) continue;
			
			if(i>0 && nums[i-1] == nums[i] && !visited[i-1]) {
				continue;
			}
			
			visited[i] = true;
			list.add(nums[i]);
			dfs(nums, res, visited, list);
			visited[i] = false;
			list.remove(list.size()-1);
		}
		
	}

}
