package edu.LeetCode.Greedy;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class No680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left=0,right=s.length()-1;
        //循环中如果字符串两侧的值一直相同，会逐渐由外而内比较，如果比较完了（left>=right）都没遇到值不同的情况则是回文串
        //比较中如果出现一次值不同的情况则只给一次机会，调用isPalindrome来检测去掉左边或去掉右边的子串是否为回文串
        //如果开始时字符串只有一个字符(left=right)或空字符(left>right)那么也不会进入循环而直接返回true了
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left + 1, right+1)) || isPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }
        //一开始做题的时候这个循环迭代我使用了递归的形式，即if (s.charAt(left) == s.charAt(right)) return validPalindrome(s.substring(left+1, right))
        //这使得某些很长的测试用例中超时了，而且创建了很多的String对象，会有很深的调用栈
        return true;
    }

    /**
     * 单次检测S是否为回文串的方法
     * @param s 要检测的String
     * @return 是否为回文串
     */
    private boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while (left < right) {
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
