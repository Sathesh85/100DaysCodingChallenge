package com.challenge.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	
	public static void main(String args[]) {
		GraphNode g = new GraphNode(1);
		GraphNode g1 = new GraphNode(2);
		GraphNode g2 = new GraphNode(3);
		GraphNode g3 = new GraphNode(4);
		g.children.addAll(Arrays.asList(g1,g2,g3));
		g3.children.addAll(Arrays.asList(g));
		CloneGraph cg = new CloneGraph();
		GraphNode res = cg.cloneGraph(g);
		System.out.println(res);
	}
	
	/*
	 * Method #1:
	 * Using HashMap technique
	 * 
	 * 
	 */
	
	private GraphNode cloneGraph(GraphNode g) {
		
		Map<Integer, GraphNode> map = new HashMap<>();
		
		Queue<GraphNode> q = new LinkedList<>();
		
		q.add(g);
		
		while(!q.isEmpty()) {
			
			GraphNode temp = q.poll();
			
			temp.isVisited = true;
			
			map.put(temp.data, new GraphNode(temp.data));
			
			for(GraphNode child: g.children) {
				if(!child.isVisited) {
					q.add(child);
				}
			}
			
		}
		
		q.add(g); 
//		GraphNode cloneNode = new GraphNode(0);
		
		while(!q.isEmpty()) {
			GraphNode temp = q.poll();
			
			temp.isVisited = false;
			
			for(GraphNode child: temp.children) {
				map.get(temp.data).children.add(map.get(child.data));
				if(child.isVisited) {
					q.add(child);
				}
			}
		}
		
		
		
		return map.get(g.data);
	}

}
