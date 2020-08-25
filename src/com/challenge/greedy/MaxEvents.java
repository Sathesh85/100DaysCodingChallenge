package com.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {

	public static void main(String[] args) {
		MaxEvents m = new MaxEvents();
		int events[][] = {{1,2}, {2,3}, {3,4}, {1,1}};
		int res = m.maxEvents(events);
		System.out.println(res);
	}

	public int maxEvents(int[][] events) {
		int res = 0;

		PriorityQueue<Integer> q = new PriorityQueue<>();

		Arrays.sort(events, (a, b) -> a[0] - b[0]);

		int i = 0, n = events.length;
		for (int d = 1; d < 100000; d++) {
			while (!q.isEmpty() && q.peek() < d) {
				q.poll();
			}
			while (i < n && events[1][0] == d) {
				q.offer(events[i++][1]);
			}
			if (!q.isEmpty()) {
				q.poll();
				res++;
			}
		}

		return res;

	}

}
