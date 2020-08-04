package edu.LeetCode.DP;

import org.junit.Test;

public class No10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s==null) s="";
        if (p==null) p="";
        if (s.equals(p)) return true;

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
/*      其实初始化时就是false
        for (int i = 1; i <= m; i++) {
            dp[i][0]=false;
        }*/
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pattern = p.charAt(j - 1);
                char chara = s.charAt(i - 1);
                if (pattern == '.' || pattern == chara) {//单个字符匹配的情况
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern == '*') {
                    //能匹配的情况，为了逻辑清除这里不合并if判断了
                    if (dp[i][j - 2]) {
                        //*前的字符出现0次
                        dp[i][j] = true;
                    } else if ((p.charAt(j - 2) == '.' || p.charAt(j - 2) == chara) && dp[i - 1][j]) {
                        //*前的字符出现1次，出现多次的情况可以从dp[i-2][j]传递过来
                        dp[i][j] = true;
                    }
                }
/*              完全不匹配
                else {
                    dp[i][j] = false;
                } */
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        System.out.println(isMatch("ab",".*"));
    }
}
