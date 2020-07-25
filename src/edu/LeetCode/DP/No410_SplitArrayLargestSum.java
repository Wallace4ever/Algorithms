package edu.LeetCode.DP;

import java.util.Arrays;

public class No410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        //dp[i][j]表示前i个数分成j个连续子数组【各自和的最大值】的最小值 j<=i
        //则dp[i][j]=Min(Math.max(dp[k][j-1],sum(k+1,i)))，k从0取到i-1
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        //sum数组保存nums的前缀和，便于快速计算nums[i]~nums[j]的和
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }

    public int splitArray2(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = 1;
            int group = 0;
            for (int num : nums) {
                group += num;
                if (group > mid) {
                    group = num;
                    count++;
                }
            }
            if (count > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
