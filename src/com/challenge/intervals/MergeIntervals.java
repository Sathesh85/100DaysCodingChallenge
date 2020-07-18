package com.challenge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 35 }, { 40, 50 } };

		MergeIntervals m = new MergeIntervals();

		int[][] mergeArr = m.merge(intervals);
		System.out.println(mergeArr);
	}

	public int[][] merge(int[][] intervals) {

		if(intervals.length == 0){
            return intervals;
        }
        
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        

		List<int[]> result = new ArrayList<>();

		int e = intervals[0][1];
		int s = intervals[0][0];
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] <= e) {
				if (intervals[i][1] >= e) {
					e = intervals[i][1];
				}
			} else {
				result.add(new int[] { s, e });
				s = intervals[i][0];
				e = intervals[i][1];
			}
		}
		
		if(s!=-1) {
			result.add(new int[] { s, e });
		}

		return result.toArray(new int[result.size()][]);

	}

}
