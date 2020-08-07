package edu.LeetCode.DP;

import org.junit.Test;

public class No121_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > min)
                maxProfit = Math.max(maxProfit, prices[i] - min);
            else
                min = prices[i];
        }
        return maxProfit;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

class No122_BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int greedyProfit = prices[i] - prices[i - 1];
            if (greedyProfit > 0) totalProfit += greedyProfit;
        }
        return totalProfit;
    }
}