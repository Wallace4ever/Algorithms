package edu.LeetCode.DP;

public class No123_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        int n = prices.length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int maxProfit1 = 0, maxProfit2 = 0;
        for (int price : prices) {
            min1 = Math.min(min1, price);
            maxProfit1 = Math.max(maxProfit1, price - min1);
            min2 = Math.min(min2, price - maxProfit1);
            maxProfit2 = Math.max(maxProfit2, price - min2);
        }
        return maxProfit2;
    }
}
