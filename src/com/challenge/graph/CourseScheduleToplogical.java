package com.challenge.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CourseScheduleToplogical {
	
	public static void main(String[] args) {
		CourseScheduleToplogical c = new CourseScheduleToplogical();
		int[][] val = new int[][] {{1,0}, {0,1}};
		boolean res = c.canFinish(3, val);
		System.out.println(res);
	}

	private boolean canFinish(int numCourses, int[][] prerequisites) {
		
		Map<Integer, GNode> map = new HashMap<>();
		
		for(int[] relation: prerequisites) {
			GNode prevNode = createNode(map, relation[1]);
			GNode nextNode = createNode(map, relation[0]);
			
			prevNode.outNodeList.add(relation[0]);
			nextNode.inNode += 1;
		}
		
		LinkedList<Integer> noDepNode = new LinkedList<>();
		for(Entry<Integer, GNode> entry : map.entrySet()) {
			if(entry.getValue().inNode == 0) {
				noDepNode.add(entry.getKey());
			}
		}
		
		int removedNodes = 0; 
		while(noDepNode.size()!=0) {
			int currCourse = noDepNode.pop();
			
			for(int nextCourse: map.get(currCourse).outNodeList) {
				GNode child = map.get(nextCourse);
				child.inNode -= 1;
				removedNodes += 1;
				if(child.inNode == 0) {
					noDepNode.add(nextCourse);
				}
			}
		}
		
		if(removedNodes != prerequisites.length) {
			return false;
		}
		return true;
	}

	private GNode createNode(Map<Integer, GNode> map, int i) {
		if(map.containsKey(i)) {
			return map.get(i);
		} else {
			GNode node = new GNode();
			map.put(i, node);
			return node;
		}
	}
	
	

}

class GNode{
	int inNode = 0;
	List<Integer> outNodeList = new LinkedList<>();
}
