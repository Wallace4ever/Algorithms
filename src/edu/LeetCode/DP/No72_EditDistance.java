package edu.LeetCode.DP;

public class No72_EditDistance {
    //递归解法
    public static int minDistance(String word1, String word2) {
        if (word1==null&&word2==null) return 0;
        if (word1==null||word1.length()==0) return word2.length();
        if (word2==null||word2.length()==0) return word1.length();
        int n=word1.length(),m=word2.length();
        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return minDistance(word1.substring(0, n - 1), word2.substring(0, m - 1));
        } else {
            return 1+Math.min(minDistance(word1.substring(0, n), word2.substring(0, m - 1)),
                    Math.min(minDistance(word1.substring(0, n-1), word2.substring(0, m - 1)),
                            minDistance(word1.substring(0, n-1), word2.substring(0, m )))
                    );
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistance2("horse","ros"));
    }

    //动态规划解法
    public static int minDistance2(String word1, String word2) {
        if (word1==null&&word2==null) return 0;
        if (word1==null||word1.length()==0) return word2.length();
        if (word2==null||word2.length()==0) return word1.length();
        int n=word1.length(),m=word2.length();
        //dp[i][j]表示word1的[0,i]的子串到word2的[0,j]的子串的最小编辑距离
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j]=j;
        }
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < m+1 ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[n][m];
    }
}
