package edu.LeetCode.DP;

/**
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。
 * 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * 0 <= K <= N <= 10000；
 * 1 <= W <= 10000
 */
public class No837_New21Game {
    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] p=new double[K+W];
/*        for (int i = K + W - 1; i >= K; i--) {
            if (i>N)
                p[i]=0.0;
            else
                p[i]=1.0;
        }*/
        for (int i = K; i <= N && i < K + W; i++) {
            p[i] = 1.0;
        }
        p[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            p[i] = p[i + 1] - (p[i + W + 1] - p[i + 1]) / W;
        }
        return p[0];
    }
}
