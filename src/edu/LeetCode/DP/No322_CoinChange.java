package edu.LeetCode.DP;

import org.junit.Test;

import java.util.Arrays;

public class No322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins==null||coins.length==0||amount<0) return -1;
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        //初始化边界情况，只选择一枚硬币
        for (int coin : coins) {
            if(coin<=amount){
                dp[coin]=1;
            }
        }

        for (int i = 1; i <=amount ; i++) {
            //如果当前金额可以达到
            if (dp[i]!=-1){
                //选择一枚硬币
                for (int coin : coins) {
                    if (amount-coin>=i) {
                        dp[i + coin] = dp[i + coin] == -1 ? dp[i] + 1 : Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1,2147483647},2));
    }
}
