package com.challenge.priority_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomAllocation {
	
	public static void main(String[] args) {
		int[][] intervals = {{0,30},{15,20},{5,10},{16,18},{20,25},{10,20}};
		
		MeetingRoomAllocation m = new MeetingRoomAllocation();
		
		int minRoomRequired = m.minMeetingRooms(intervals);
		System.out.println(minRoomRequired);
	}
	
	 public int minMeetingRooms(int[][] intervals) {
		 PriorityQueue<Integer> allocator = new PriorityQueue<>();
		 
		 
		 Arrays.sort(intervals,  (int[] a, int[] b)-> a[0]-b[0]);
		 
		 allocator.add(intervals[0][1]);
		 
		 for(int i =1; i< intervals.length; i++) {
			 
			 if(allocator.peek()<intervals[i][1]) {
				 allocator.poll();
			 }
			 allocator.add(intervals[i][1]);
		 }
		 
		 return allocator.size();
	 }

}
