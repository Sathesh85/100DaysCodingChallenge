package com.challenge.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	
	int data;
	List<GraphNode> children;
	boolean isVisited = false;
	
	GraphNode(int data){
		this.data = data;
		children = new ArrayList<>();
	}
	
	GraphNode(){
		children = new ArrayList<>();
	}

}
