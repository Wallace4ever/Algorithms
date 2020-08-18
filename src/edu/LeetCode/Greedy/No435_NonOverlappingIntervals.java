package edu.LeetCode.Greedy;

import java.util.Arrays;

public class No435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1, lastEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }
        return intervals.length - count;
    }
}
