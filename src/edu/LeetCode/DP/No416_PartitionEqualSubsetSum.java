package edu.LeetCode.DP;

public class No416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) return false;
        int m = nums.length, n = sum / 2;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = dp[i - 1][j] || (nums[i - 1] <= j && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[m][n];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) return false;
        int m = nums.length, n = sum / 2;
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >=0 ; j--) {
                dp[j] = dp[j] || (j - nums[i-1] >= 0 && dp[j - nums[i-1]]);
            }
        }
        return dp[n];
    }
}
