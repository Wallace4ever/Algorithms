package edu.LeetCode.Greedy;

import java.util.ArrayList;

public class No986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][];
        int indexA = 0, indexB = 0;
        ArrayList<int[]> intersections = new ArrayList<>();
        while (indexA < A.length && indexB < B.length) {
            int aL = A[indexA][0], aR = A[indexA][1];
            int bL = B[indexB][0], bR = B[indexB][1];
            if (aR >= bL && bR >= aL) {
                intersections.add(new int[]{Math.max(aL, bL), Math.min(aR, bR)});
            }
            if (aR < bR)
                indexA++;
            else
                indexB++;
        }
        return intersections.toArray(new int[0][]);
    }
}
