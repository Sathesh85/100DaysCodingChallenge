package com.challenge.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberProblem {
	
	public static void main(String[] args) {
		PhoneNumberProblem p = new PhoneNumberProblem();
		System.out.println(p.letterCombinations("283"));
		
	}

	Map<String, String> phone = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	public List<String> letterCombinations(String digits) {
		
		List<String> res = new ArrayList<>();
		
		if(digits.length()>0) {
			helper(res, digits,"");
		}
		return res;
		        
	}

	private void helper(List<String> res, String digits, String comb) {
		if(digits.length()==0) {res.add(comb);return;}
		
		String letters = phone.get(digits.substring(0,1));
		
		for(int i =0 ; i < letters.length(); i++) {
			helper(res, digits.substring(1), comb+letters.charAt(i));
		}
		
	}

}
