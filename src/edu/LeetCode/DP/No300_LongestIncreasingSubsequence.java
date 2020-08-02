package edu.LeetCode.DP;

import org.junit.Test;

public class No300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0)
                dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
