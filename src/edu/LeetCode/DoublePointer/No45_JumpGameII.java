package edu.LeetCode.DoublePointer;

import org.junit.Test;

public class No45_JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0, steps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                steps++;
                end = farthest;
            }
        }
        return steps;
    }

    @Test
    public void test() {
        System.out.println(jump(new int[]{0}));
    }
}
