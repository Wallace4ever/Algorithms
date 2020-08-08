package edu.LeetCode.DP;

import org.junit.Test;

import java.util.Arrays;

public class No123_BestTimeBuySellStockIII {
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

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        int n = prices.length;
        int[] min = new int[2];
        int[] maxProfit = new int[2];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 0; i < 2; i++) {
                min[i] = Math.min(min[i], i == 0 ? price : price - maxProfit[i - 1]);
                maxProfit[i] = Math.max(maxProfit[i], price - min[i]);
            }
        }
        return maxProfit[1];
    }

    @Test
    public void test() {
        System.out.println(maxProfit2(new int[]{3,3,5,0,0,3,1,4}));
    }
}
