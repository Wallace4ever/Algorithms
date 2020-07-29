package edu.LeetCode.DP;

import org.junit.Test;

import java.util.Arrays;

public class No518_CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j-coins[i-1]>=0)
                    dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        System.out.println(change(5,new int[]{1,2,5}));
    }
}
