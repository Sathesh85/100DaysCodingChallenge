package com.challenge.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloneGraphByDFS {
	
	public static void main(String args[]) {
		GraphNode g = new GraphNode(1);
		GraphNode g1 = new GraphNode(2);
		GraphNode g2 = new GraphNode(3);
		GraphNode g3 = new GraphNode(4);
		g.children.addAll(Arrays.asList(g1,g2,g3));
		g3.children.addAll(Arrays.asList(g));
		CloneGraphByDFS cg = new CloneGraphByDFS();
		GraphNode res = cg.cloneGraph(g, new HashMap<GraphNode, GraphNode>());
		System.out.println(res);
	}
	
	private GraphNode cloneGraph(GraphNode root, Map<GraphNode, GraphNode> map) {
		
		if(map.containsKey(root)) {
			return map.get(root);
		}
		
		GraphNode cloneNode = new GraphNode(root.data);
		map.put(root, cloneNode);
		
		for(GraphNode child: root.children) {
			cloneNode.children.add(cloneGraph(child, map));
		}

		return cloneNode;
	}

}
