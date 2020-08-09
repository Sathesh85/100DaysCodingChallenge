package com.challenge.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordBreak {
	
	public static void main(String[] args) {
		WordBreak r = new WordBreak();
		boolean ans = r.workBreak1("catsanddogs", new HashSet<String>(Arrays.asList("cats","cat","and","sand","dog")));
		System.out.println(ans);
	}

	/**
	 * @param str
	 * @param hashSet
	 * @return
	 * 
	 * 
	 * Approach using dynamic programming
	 */
	private boolean workBreak(String str, HashSet<String> hashSet) {
		boolean arr[] = new boolean[str.length()+1];
		arr[0] = true;
		
		for(int i=1;i<=str.length(); i++) {
			for(int j= 0; j<i;j++) {
				if(arr[j] && hashSet.contains(str.substring(j, i))) {
					arr[i] = true;
					break;
				}
			}
		}
		
		int i =0;
		
		for(boolean a : arr) {
			System.out.println(i++ +" "+a);
		}
		return arr[str.length()];
	}
	
	/**
	 * @param str
	 * @param hashSet
	 * @return
	 * 
	 * Using BFS
	 */
	private boolean workBreak1(String str, HashSet<String> hashSet) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) { 
			
			int start = q.poll();
			
			for(int i = start+1; i<=str.length(); i++) {
				if(hashSet.contains(str.substring(start,i))) {
					q.add(i);
					if(i==str.length()) {
						return true;
					}
				}
				
			}
		}
		
		return false;
		
	}

}
