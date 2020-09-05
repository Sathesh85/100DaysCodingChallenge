package com.challenge.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class NonOverlappingSubarray {
	
	public int minSumOfLength(int arr[], int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			map.put(sum, i);
		}
		
		sum = 0;
		
		int result = Integer.MAX_VALUE;
		int lMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			
			sum += arr[i];
			
			if(map.containsKey(sum-target)) {
				lMin = Math.min(lMin, i - map.get(sum-target));	
			}
			
			if(map.containsKey(sum+target) && lMin< Integer.MAX_VALUE) {
				result = Math.min(result, map.get(sum+target) - i + lMin);
			}
			
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
		
		
	}

}
