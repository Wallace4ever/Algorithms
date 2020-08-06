package edu.KeyToOffer.OptimizeTime;

public class MaxSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0) return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i-1]<=0)
                dp[i]=array[i];
            else
                dp[i]=array[i]+dp[i-1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
