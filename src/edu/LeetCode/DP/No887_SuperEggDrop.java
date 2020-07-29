package edu.LeetCode.DP;

import org.junit.Test;

import java.util.Arrays;

public class No887_SuperEggDrop {

    public int superEggDrop(int K, int N) {
        //dp[i][j]表示还有i个鸡蛋要找j层楼
        int[][]dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i],10000);
        }
        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
            dp[0][j] = 0;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                for (int x = 1; x <=j ; x++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][j - x], dp[i - 1][x - 1])+1);
                }
            }
        }
        return dp[K][N];
    }



    @Test
    public void test() {
        System.out.println(superEggDrop(8,10000));
    }
}
