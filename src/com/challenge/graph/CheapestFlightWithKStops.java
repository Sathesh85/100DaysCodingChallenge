package com.challenge.graph;

public class CheapestFlightWithKStops {

	public static void main(String[] args) {
		int[][] flights ={{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
		CheapestFlightWithKStops k = new CheapestFlightWithKStops();
		int res = k.findCheapestPrice(5, flights, 0, 2, 2);
		System.out.println(res);
	}

	int min = Integer.MAX_VALUE;
	/*
	 * 
	 * Brute Force without memoziation
	 * 
	 */

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		helper(n, flights, src, dst, K, 0);
		return min;

	}

	void helper(int n, int[][] flights, int src, int dst, int K, int weigh) {

		 if(K<0){
	            return;
	        }
	        
	        for(int[] flight: flights){
	            if(src== flight[0]){
	            if(dst == flight[1]){
	               weigh += flight[2];
	               min = Math.min(weigh,min); 
	               weigh -= flight[2]; 
	            }
	                
	            else {
	                helper(n,flights,flight[1], dst, K-1,weigh + flight[2]);
	            }
	            }
	                
	        }
	        
	        
	}

}
