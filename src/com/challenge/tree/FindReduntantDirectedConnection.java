package com.challenge.tree;

public class FindReduntantDirectedConnection {
	
	/*
	 * Need to find redundant connection
	 * 
	 * In this case first ele is the parent and the second one is the child
	 * Keep the parent in the set and check if the child is already present in the map. If so add that value in a list
	 * 
	 */
	
	public static void main(String[] args) {
//		int edges[][] = {{1,2}, {1,3}, {2,3}};
//		int edges[][] = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
		int edges[][] = {{2,1},{3,1},{4,2},{1,4}};
		
		FindReduntantDirectedConnection con = new FindReduntantDirectedConnection();
		int[] finalEdge = con.findRedundantDirectedConnection(edges);
		System.out.println(finalEdge[0] + " " + finalEdge[1]);
	}

	public int[] findRedundantDirectedConnection(int[][] edges) {
		
		int rel[] = new int[edges.length +1];
		
		int val1[] = {-1,-1};
		int val2[] = {-1, -1};
		
		/*
		 * Update the edge if it has more parent
		 * and store both the edge at val1 and val2
		 */
		for(int[] edge : edges) {
			
			if(rel[edge[1]] == 0) {
				rel[edge[1]] = edge[0];
			}else {
				
				val1 = new int[]{edge[0],edge[1]};
				val2[0] = rel[edge[1]];
				val2[1] = edge[1];
				
				edge[1] = 0;
			}
		}
		
		/*
		 * Reset the rel value
		 */
		for(int i =0 ; i < edges.length+1; i++) {
			rel[i] = i;
		}
		
		for(int edge[]: edges) {
			
			if(edge[1] == 0) {
				continue;
			} else {
				if(root(edge[0],rel) == edge[1]) {
					//Cyclic
					if(val1[0] == -1) {
						return edge;
					} else {
						return val2;
					}
				}
				
				rel[edge[1]] = edge[0];
			}
		}
		
		return val1;
	}

	private int root(int i, int[] rel) {
		while(i != rel[i]) {
			
			i = rel[i];
		}
		return i;
	}

}
