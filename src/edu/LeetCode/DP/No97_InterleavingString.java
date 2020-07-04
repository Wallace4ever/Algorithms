package edu.LeetCode.DP;

public class No97_InterleavingString {
    //错误的尝试，双指针依次扫描
    //"aa"
    //"ab"
    //"aaba"
    public static boolean isInterleave0(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        int p1=0,p2=0,p3=0;
        while (p3 < s3.length()) {
            while (p1 < s1.length() && p3 < s3.length() && s1.charAt(p1) == s3.charAt(p3)) {
                p1++;
                p3++;
            }
            while (p2 < s2.length() && p3 < s3.length() && s2.charAt(p2) == s3.charAt(p3)) {
                p2++;
                p3++;
            }
            if (p3 < s3.length() && ((p1 >= s1.length() && s2.charAt(p2) != s3.charAt(p3)) || (p1 < s1.length() && s1.charAt(p1) != s3.charAt(p3)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aa","ab","aaba"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        int m=s1.length(),n=s2.length();
        boolean[][] dp=new boolean[m+1][n+1];
        boolean b=true;

        //初始化边界值
        dp[0][0]=true;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = b && (b = (s2.charAt(j-1) == s3.charAt(j-1)));
        }
        b=true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = b && (b = (s1.charAt(i-1) == s3.charAt(i-1)));
        }

        //开始DP过程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
