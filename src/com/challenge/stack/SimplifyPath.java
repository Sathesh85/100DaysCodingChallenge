package com.challenge.stack;

import java.util.Stack;

public class SimplifyPath {
	
public String simplifyPath(String path) {
        
        Stack<String> s = new Stack<>();
        
        String[] arr = path.split("/");
        
        for(String a : arr){
            if(a.equals("..")){
                if(!s.isEmpty()) {
                    s.pop();
                } else {
                    s.push("/");
                }
            } else if(a.equals(".") || a.equals("")){
                    
            }
            else {
                    s.push(a);
            }
        }
        
        StringBuilder builder = new StringBuilder();

        while(!s.isEmpty()){
            builder.insert(0,s.pop());
            builder.insert(0,"/");
        }

        
        return builder.toString();
        
    }

}
