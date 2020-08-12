package com.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		GenerateParenthesis g = new GenerateParenthesis();
		List<String> res = g.generateParenthesis(3);
		System.out.println(res);
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> list = null;
        
        if(n==0){
        	list = new ArrayList<>();
            list.add("");
            return list;
        }
        
        List<String> subParenList = generateParenthesis(n-1);
        
        list = new ArrayList<>();
        for(String p : subParenList){
            String res = new String();
            for(int i =0; i< p.length(); i++){
                if(p.charAt(i)=='('){
                    res = p.substring(0,i+1) + "()" + p.substring(i+1);
                    list.add(res);
                }  
            }
            list.add(p+"()");
        }
        
        return list;
    }

}
