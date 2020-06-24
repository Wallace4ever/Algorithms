package edu.LeetCode.String;

/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class No5_LongestPalindromicSubstring {
    //DP
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0) return "";
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int left=0,right=0,maxLen=0;

        for (int d = 0; d <= n - 1; d++) {
            for (int i = 0; i < n - d; i++) {
                switch (d) {
                    //初始化长度为1和2的子串
                    case 0:
                        isPalindrome[i][i]=true;
                        break;
                    case 1:
                        if (s.charAt(i) == s.charAt(i + 1)) {
                            isPalindrome[i][i+1]=true;
                            left=i;
                            right=i+1;
                        }
                        break;
                    //开始DP
                    default:
                        if (isPalindrome[i + 1][i + d - 1] && s.charAt(i) == s.charAt(i + d)) {
                            isPalindrome[i][i + d] = true;
                            if (d > maxLen) {
                                maxLen = d;
                                left = i;
                                right = i + d;
                            }
                        }
                }
            }
        }
        return s.substring(left,right+1);
    }

    //中心扩展
    public String longestPalindrome2(String s){
        if (s==null||s.length()==0) return "";
        int start=0,end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len > end - start) {
                start=i-(int)Math.floor(len/2.0);
                end=i+(int)Math.ceil(len/2.0);
            }
        }
        return s.substring(start,end+1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-2;
    }
}
