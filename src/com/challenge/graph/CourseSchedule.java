package com.challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	public static void main(String[] args) {
		CourseSchedule c = new CourseSchedule();
		int[][] val = new int[][] {{1,0}, {2,0}};
		boolean res = c.canFinish(3, val);
		System.out.println(res);
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] pair: prerequisites){
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        
        for(int currCourses = 0 ; currCourses<numCourses ; ++currCourses){
            if(isCyclic(currCourses, map, visited, path)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isCyclic(
      Integer currCourse, Map<Integer, List<Integer>> map,
      boolean[] checked, boolean[] path) {
        if(checked[currCourse]){
            return false;
        }
        if(path[currCourse]){
            return true;
        }
        
        if(!map.containsKey(currCourse)){
            return false;
        }
        
        path[currCourse] = true;
        
        boolean ret = false;
        for(int child : map.get(currCourse)){
            ret = isCyclic(child, map, checked, path);
            if(ret){
                break;
            }
        }
        path[currCourse] = false;
        checked[currCourse] = true;
        return ret;
        
    }

}
