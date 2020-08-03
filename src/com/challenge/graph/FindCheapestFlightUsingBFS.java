package com.challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindCheapestFlightUsingBFS {
	
	public static void main(String[] args) {
		int[][] flights = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
		FindCheapestFlightUsingBFS k = new FindCheapestFlightUsingBFS();
		int res = k.findCheapestPrice(5, flights, 0, 2, 2);
		System.out.println(res);
	}

	private int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] i : flights) {
			map.putIfAbsent(i[0], new ArrayList<>());
			map.get(i[0]).add(new int[] {i[1], i[2]});
		}
		
		Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] -b[0]);
		
		queue.add(new int[] {0,src,K+1});
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			if(curr[2]<0) {
				continue;
			}
			
			if(curr[1] == dst) {
				return curr[0];
			}
			
			if(!map.containsKey(curr[1])) {
				continue;
			}
			
			for(int[] f : map.get(curr[1])) {
				queue.add(new int[] {f[1]+curr[0], f[0], curr[2]-1});
			}
			
		}
		
		return -1;
	}

	int min = Integer.MAX_VALUE;
	
	/*
	 * Without priority queue
	 */
	
	 /*public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
			
			Map<Integer, List<int[]>> map = new HashMap<>();
			
			for(int[] i : flights) {
				map.putIfAbsent(i[0], new ArrayList<>());
				map.get(i[0]).add(new int[] {i[1], i[2]});
			}
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.add(new int[] {0,src,K+1});
			
			while(!queue.isEmpty()) {
				
				int[] curr = queue.poll();
				
				if(curr[2]<0) {
					continue;
				}
				
				if(curr[1] == dst) {
					min = Math.min(min, curr[0]);
				}
				
				if(!map.containsKey(curr[1])) {
					continue;
				}
				
				for(int[] f : map.get(curr[1])) {
					if(min< curr[0] + f[1]) {
						continue;
					}
					queue.add(new int[] {f[1]+curr[0], f[0], curr[2]-1});
				}
				
			}
			
			return min == Integer.MAX_VALUE ? -1 : min;
		

		}*/

	
	

}
