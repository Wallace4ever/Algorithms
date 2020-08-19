package edu.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class No56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= right) {
                right = Math.max(right, interval[1]);
            } else {
                merged.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        merged.add(new int[]{left, right});
        return merged.toArray(new int[0][]);
    }
}
