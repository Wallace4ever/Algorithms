package edu.LeetCode.String;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class No125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null) return false;
        if (s.length()==0) return true;
        int left=0,right=s.length()-1;
        while (true) {
            while (left < s.length()&&!inRange(s.charAt(left))) {
                left++;
            }
            while (right >=0&&!inRange(s.charAt(right))) {
                right--;
            }
            if (right < left) {
                return true;
            } else {
                int distance = Math.abs(s.charAt(right)-s.charAt(left));
                if (!(distance==0||distance==32)) return false;
                left++;
                right--;
            }
        }
    }

    private boolean inRange(char c) {
        return (c>='0'&&c<='9')||(c>='A'&&c<='Z')||(c>='a'&&c<='z');
    }

    public static void main(String[] args) {
        StringBuffer sgood = new StringBuffer("lo");
        StringBuffer g=new StringBuffer(sgood);
        System.out.println(sgood.equals(g));
    }
}
