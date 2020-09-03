package com.challenge.dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDictionary {
	Trie root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)) {
            	curr.children.put(ch, new Trie());
            }
            curr = curr.children.get(ch);
        }
        curr.islast = true;
    }
    
     public boolean search(String word) {
    	return search(word,root);
        
    }
    
    public boolean search(String word, Trie node) {
    for (int i = 0; i < word.length(); ++i) {
        char ch = word.charAt(i);
        if (!node.children.containsKey(ch)) {
            if (ch == '.') {
                for (char x : node.children.keySet()) {
                    Trie child = node.children.get(x);
                    if (search(word.substring(i + 1), child)) {
                        return true;    
                    }    
                }   
            }
            return false;    
        } else {
            node = node.children.get(ch); 
        }   
    }      
    return node.islast;
}

}

class Trie{
    Map<Character, Trie> children = new HashMap<>();
    boolean islast = false;
    
    Trie(){
    	
    }
    
}