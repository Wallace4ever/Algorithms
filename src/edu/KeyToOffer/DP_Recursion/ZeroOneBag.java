package edu.KeyToOffer.DP_Recursion;

import org.junit.Test;

public class ZeroOneBag {
    //动态规划解法
    public int getMaxValue(int[] weight, int[] value, int capacity) {
        if (weight==null||value==null||capacity==0||weight.length==0||value.length==0) return 0;
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=capacity ; j++) {
                if (j - weight[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[n][capacity];
    }

    //掩码方式穷举，最多只支持30位/62位的物品数组，更多就需要使用回溯法来穷举了，计算量很大
    public int getMaxValue2(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int mask = 1 << n;
        int maxValue = 0;
        for (int i = 0; i < mask; i++) {
            int totalValue = 0, totalWeight = 0;
            for (int j = 0; j < n; j++) {
                if (((i >>> j) & 1) == 1) {
                    totalValue += value[j];
                    totalWeight += weight[j];
                }
            }
            if (totalWeight <= capacity) {
                maxValue = Math.max(maxValue, totalValue);
            }
        }
        return maxValue;
    }

    @Test
    public void test() {
        //int掩码最多只能由1左移30位
        int a=(1<<31)-1;
        long b=(1L<<63)-1;
        System.out.println(a);
        System.out.println(b);
        System.out.println((-1)<<2);
        //System.out.println(getMaxValue2(new int[]{2,1,3},new int[]{4,2,3},4));
    }
}
