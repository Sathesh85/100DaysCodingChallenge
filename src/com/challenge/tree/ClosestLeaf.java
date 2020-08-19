package com.challenge.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class ClosestLeaf {
	
	public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        
        for(TreeNode node : graph.keySet()){
            if(node!=null && node.val == k){
                queue.add(node);
                seen.add(node);
            }
        }
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                if(graph.get(node).size()<=1){
                    return node.val;
                } else {
                    for(TreeNode child : graph.get(node)){
                        if(!seen.contains(child)){
                            seen.add(child);
                            queue.add(child);
                        }
                    }
                }
            }
        }
        
     return -1;
        
    }
    
    void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        graph.putIfAbsent(node, new ArrayList<>());
        graph.putIfAbsent(parent, new ArrayList<>());
        
        graph.get(node).add(parent);
        graph.get(parent).add(node);
        
        dfs(graph, node.left, node);
        dfs(graph, node.right, node);
    }
    

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
       this.left = left;
       this.right = right;
    }
 }
