package edu.LeetCode.DP;

public class No70_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) {
            return 0;
        }
        //初始化第一天和第二天
        int[] dpBuy = new int[n], dpSell = new int[n];
        dpSell[0] = 0;
        dpBuy[0] = -prices[0];
        dpSell[1] = Math.max(dpSell[0], dpBuy[0] + prices[1]);
        dpBuy[1] = Math.max(dpBuy[0], dpSell[0] - prices[1]);
        for(int i=2;i<n;++i) {
            //求第i天累计卖出最大利润，累计买入的最大利润
            dpSell[i] = Math.max(dpSell[i-1],dpBuy[i-1]+prices[i]);
            dpBuy[i]= Math.max(dpBuy[i-1],dpSell[i-2]-prices[i]);
        }
        return Math.max(dpSell[n-1],dpBuy[n-1]);
    }
}
