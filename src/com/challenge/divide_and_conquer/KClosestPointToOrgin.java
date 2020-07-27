package com.challenge.divide_and_conquer;

import java.util.PriorityQueue;

public class KClosestPointToOrgin {
	
	public static void main(String[] args) {
		KClosestPointToOrgin f = new KClosestPointToOrgin();

		
		int point[][] = {{3,3},{5,-1},{-2,4}};
		point = f.kClosest(point, 2);
		
		System.out.println(point);
	}
	
	public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> {return (int) (getSqured(o2)-getSqured(o1));});
        
        for(int i =0; i < (points.length < K? points.length :K) ; i++){
            q.add(points[i]);
        }
        
        for(int i = K; i< points.length ; i++){
            if(getSqured(q.peek())>getSqured(points[i])){
                q.poll();
                q.add(points[i]);
            }
        }
        
        return q.toArray(new int[q.size()][]);
        
    }
    
    private double getSqured(int[] point){
        return Math.pow(point[0],2) + Math.pow(point[1],2);
    }


}
