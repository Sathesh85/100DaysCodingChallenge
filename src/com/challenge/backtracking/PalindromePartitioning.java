package com.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		System.out.println(p.partition("abb"));
	}
	
	
	
	public List<List<String>> partition(String s) {
		
		List<List<String>> res = new ArrayList<>();
		List<String> list = new ArrayList<>();
		
		dfs(s,0,list,res);
		
		return res;
		
	}

	private void dfs(String s, int pos, List<String> list, List<List<String>> res) {

		if(pos == s.length()) {
			res.add(new ArrayList<String>(list));
		}else {
			for (int i = pos; i < s.length(); i++) {
				if(isPalin(s, pos, i)) {
					list.add(s.substring(pos, i+1));
					dfs(s, i+1, list, res);
					list.remove(list.size()-1);
				}
				
			}
		}
	}

	private boolean isPalin(String s, int low, int high) {
		while(low<high) {
			if(s.charAt(low++) != s.charAt(high--)) {
				return false;
			}
		}
		return true;
	}

}
