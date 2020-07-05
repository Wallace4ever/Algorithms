package edu.LeetCode.DP;

public class No91_DecodeWays {
    public int numDecodings(String s) {
        if(s==null||s.length()==0|| toInt(s.charAt(0))==0) return 0;
        int n=s.length();
        if(n==1) return 1;

        int[] dp=new int[n];
        dp[0]=1;
        int a=toInt(s.charAt(0)),b=toInt(s.charAt(1));
        if (match2(a, b) && match1(b)) {
            dp[1]=2;
        } else if (!match2(a, b) && !match1(b)) {
            dp[1]=0;
        }else{
            dp[1]=1;
        }
        if (n==2) return dp[1];

        for (int i = 2; i < n; i++) {
            int curr=toInt(s.charAt(i)),curr_1=toInt(s.charAt(i-1));
            if (match1(curr)) {
                if (match2(curr_1, curr)) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (match2(curr_1, curr)) {//e.g. [1,2,0,...]
                    dp[i] = dp[i - 2];
                } else {
                    dp[i]=0;
                }
            }
        }
        return dp[n-1];
    }

    private int toInt(char c){
        return (int)c-'0';
    }

    private boolean match2(int a, int b){
        int tmp=a*10+b;
        return tmp>=10&&tmp<=26;
    }

    private boolean match1(int a){
        return 0<a&&9>=a;
    }
}
