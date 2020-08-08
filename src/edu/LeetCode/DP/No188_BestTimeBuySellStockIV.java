package edu.LeetCode.DP;

import org.junit.Test;

import java.util.Arrays;

public class No188_BestTimeBuySellStockIV {
    public int maxProfit(int k,int[] prices) {
        if (k <= 0 || prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        if (k > n/2) return maxProfit(prices);
        int[] min = new int[k];
        int[] maxProfit = new int[k];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                min[i] = Math.min(min[i], i == 0 ? price : price - maxProfit[i - 1]);
                maxProfit[i] = Math.max(maxProfit[i], price - min[i]);
            }
        }
        return maxProfit[k-1];
    }

    private int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int greedyProfit = prices[i] - prices[i - 1];
            if (greedyProfit > 0) totalProfit += greedyProfit;
        }
        return totalProfit;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(2,new int[]{3,7,2,5,0,3}));
    }
}
