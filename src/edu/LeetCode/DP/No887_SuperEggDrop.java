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
        }
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                //线性搜索所有x可能的取值
                for (int x = 1; x <=j ; x++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][j - x], dp[i - 1][x - 1])+1);
                }
            }
        }
        return dp[K][N];
    }

    public int superEggDrop2(int K, int N) {
        //dp[k][m] = n
        //当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
        //这个状态下，最坏情况下最多能确切测试一栋 n 层的楼
        int[][]dp = new int[K + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
            //dp[0][j] = 0;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }



    @Test
    public void test() {
        System.out.println(superEggDrop2(8,10000));
    }
}
