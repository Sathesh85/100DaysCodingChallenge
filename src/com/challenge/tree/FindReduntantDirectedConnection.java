package com.challenge.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindReduntantDirectedConnection {
	
	/*
	 * Need to find redundant connection
	 * 
	 * In this case first ele is the parent and the second one is the child
	 * Keep the parent in the set and check if the child is already present in the map. If so add that value in a list
	 * 
	 */
	
	public static void main(String[] args) {
		int edges[][] = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
		
		FindReduntantDirectedConnection con = new FindReduntantDirectedConnection();
		int[] finalEdge = con.findRedundantDirectedConnection(edges);
		System.out.println(finalEdge[0] + " " + finalEdge[1]);
	}

	public int[] findRedundantDirectedConnection(int[][] edges) {
		
		Set<Integer> set = new HashSet<>();
		LinkedList<int[]> res = new LinkedList<>();
		
		for(int[] edge : edges) {
			if(set.contains(edge[1])) {
				res.add(edge);
			} else {
				set.add(edge[0]);
				set.add(edge[1]);
			}
		}

		return res.getLast();
	}

}
