package edu.LeetCode.BinarySearch;

import org.junit.Test;

public class No875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1, max = Integer.MIN_VALUE;
        for (int pile : piles)
            max = Math.max(max, pile);
        while (min <= max) {
            int mid = min + ((max - min) >> 1);
            if (canFinish(piles, H, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] piles, int H, int speed) {
        int hour = 0;
        for (int pile : piles)
            hour += Math.ceil((double) pile / speed);
        return hour <= H;
    }

    @Test
    public void test() {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
    }
}
