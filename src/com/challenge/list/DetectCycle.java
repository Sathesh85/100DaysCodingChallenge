package com.challenge.list;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {
	
	 public Integer detectCycle(ListNode head) {
	        
	        Map<ListNode, Integer> map = new HashMap<>();
	        
	        ListNode temp = head;
	        int pos = 0;
	        while(temp!=null){
	            if(map.containsKey(temp)){
	                return map.get(temp);
	            }
	            map.put(temp, pos++);
	            temp = temp.next;
	        }
	        
	        return null;
	        
	    }

}
