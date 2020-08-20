package com.challenge.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulatingNextRightPointer {
	public NodeN connect(NodeN root) {
		
		if(root ==  null) {
			return root;
		}
		
		NodeN leftMost = root;
		
		while(leftMost.left!=null) {
			NodeN head = leftMost;
			
			while(head != null) {
				head.left.next = head.right;
				
				if(head.next!=null) {
					head.right.next = head.next.left;
				}
				head = head.next;
			}
			leftMost = leftMost.left;
		}
		
		
		return root;

	}
	
	
	public NodeN connectWithExtraSpace(NodeN root) {
        
        Map<Integer, List<NodeN>> map = new HashMap<>();
        convertToMap(map, root, 0);
        
        for(List<NodeN> nodeList : map.values()){
            for(int i=0;i<nodeList.size()+1; i++){
                nodeList.get(i).next = nodeList.get(i+1);
            }
        }
        
        return root;
        
    }
    
    void convertToMap(Map<Integer, List<NodeN>> map, NodeN root, int level){
        
        if(root==null){
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root);
        convertToMap(map,root.left,level+1);
        convertToMap(map,root.right,level+1);
    }
}

class NodeN{
	public int val;
    public NodeN left;
    public NodeN right;
    public NodeN next;

    public NodeN() {}
    
    public NodeN(int _val) {
        val = _val;
    }
}
