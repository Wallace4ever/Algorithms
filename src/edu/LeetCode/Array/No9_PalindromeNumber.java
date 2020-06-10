package edu.LeetCode.Array;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class No9_PalindromeNumber {
    //转为字符串(字符数组)的解法
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        for (int l = 0, r = s.length()-1; l <= r; l++, r--) {
            if (s.charAt(l)!=s.charAt(r))
                return false;
        }
        return true;
    }

    //转为整形数组
    public boolean isPalindrome2(int x) {
        if (x<0) return false;
        int y=x,length=0;
        do {
            length++;
            y/=10;
        }while (y!=0);
        int[] array=new int[length];
        for (int i = length-1; i >=0; i--) {
            array[i]=x%10;
            x/=10;
        }
        for (int l = 0, r = length - 1; l <= r; l++, r--) {
            if (array[l]!=array[r]) return false;
        }
        return true;
    }

    //直接翻转一半长度的数值
    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedHalf = 0;
        while (x > revertedHalf) {
            revertedHalf = revertedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == revertedHalf || x == revertedHalf / 10;
    }
}
