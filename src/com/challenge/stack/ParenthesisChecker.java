package com.challenge.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {
	
	public static void main(String args[]) {
		List<Character> list = Arrays.asList('{','[',']','}','{','}');
		ParenthesisChecker c = new ParenthesisChecker();
		boolean out = c.checkParanthesis(list);
		System.out.println(out);
	}
	
	/*
	 * 
	 * Check if ( { [
	 * 
	 */
	
	private boolean checkParanthesis(List<Character> list) {
		Stack<Character> s = new Stack<>();
		
		Map<Character,Character> parenMap = new HashMap<>();
		parenMap.put('{', '}');
		parenMap.put('(', ')');
		parenMap.put('[', ']');
		
		for(char ch : list) {
			if(parenMap.containsKey(ch)) {
				s.push(ch);
			} else {
				if(s.isEmpty() || !(parenMap.get(s.peek()) == ch)) {
					return false;
				}
				s.pop();
			}
		}
		if(!s.isEmpty()) {
			return false;
		}
		
		return true;
		
	}

}
