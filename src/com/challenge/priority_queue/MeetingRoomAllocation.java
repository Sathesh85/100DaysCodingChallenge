package com.challenge.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomAllocation {

	public static void main(String[] args) {
//		int[][] intervals = { { 5, 8 }, { 6, 8 } };
		int[][] intervals = { { 0,30 }, { 15,20 }, {5,10} };

		MeetingRoomAllocation m = new MeetingRoomAllocation();

		int minRoomRequired = m.minMeetingRooms(intervals);
		System.out.println(minRoomRequired);
	}

	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> allocator = new PriorityQueue<>();

		Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

		allocator.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] >= allocator.peek()) {
				allocator.poll();
			}
			allocator.add(intervals[i][1]);
		}

		return allocator.size();
	}

}
