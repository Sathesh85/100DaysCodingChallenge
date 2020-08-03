package com.challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheapestFlightWithKStops {

	public static void main(String[] args) {
		int[][] flights = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
		CheapestFlightWithKStops k = new CheapestFlightWithKStops();
		int res = k.findCheapestPrice(5, flights, 0, 2, 2);
		System.out.println(res);
	}

	int min = Integer.MAX_VALUE;

	/*
	 * Cheap Flights problem by creating a map basesd on source
	 * 
	 */

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] i : flights) {
			map.putIfAbsent(i[0], new ArrayList<>());
			map.get(i[0]).add(new int[]{i[1],i[2]});
		}
		helper(map, flights, src, dst, K, 0);
		return min;

	}

	void helper(Map<Integer, List<int[]>> map, int[][] flights, int src, int dst, int K, int weigh) {

		if (K < -1) {
			return;
		}
		
		if(src ==  dst) {
			min = Math.min(weigh, min);
			return;
		}
		
		if(!map.containsKey(src)) {
			return;
		}

		for (int[] flight : map.get(src)) {
			helper(map, flights, flight[0], dst, K - 1, weigh + flight[1]);
		}

	}

	/*
	 * 
	 * Brute Force without memoziation
	 * 
	 * 
	 * 
	 * public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
	 * { helper(n, flights, src, dst, K, 0); return min;
	 * 
	 * }
	 * 
	 * void helper(int n, int[][] flights, int src, int dst, int K, int weigh) {
	 * 
	 * if(K<0){ return; }
	 * 
	 * for(int[] flight: flights){ if(src== flight[0]){ if(dst == flight[1]){ weigh
	 * += flight[2]; min = Math.min(weigh,min); weigh -= flight[2]; }
	 * 
	 * else { helper(n,flights,flight[1], dst, K-1,weigh + flight[2]); } }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
}
