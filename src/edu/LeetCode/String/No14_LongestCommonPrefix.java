package edu.LeetCode.String;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 */
public class No14_LongestCommonPrefix {
    //纵向扫描法：首先找到输入的所有字符串的最小长度L，则用于扫描前缀的指针i大小不会超过L-1。
    // 接下来对于每个i，比较每个str.charAt(i)是否相同，一旦发现不同返回[0,i-1]的子串
    // 扫描完L-1位后都没有发现不同，则返回[0,L-1]的子串。
    public String longestCommonPrefix(String[] strs) {
        //数组本身为空或不含元素则返回空串
        if (strs==null||strs.length==0) return "";
        int minLength=Integer.MAX_VALUE;
        for (String str : strs) {
            //扫描最小长度的过程中如果发现空串则返回空串
            if (str==null||str.length()==0) return "";
            minLength=Math.min(minLength,str.length());
        }
        //到这里数组的第一个字符串肯定不是空串
        char c=strs[0].charAt(0);
        for (int i = 0; i < minLength; i++) {
            for (String str : strs) {
                if (str.charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,minLength);
    }

    public String longestCommonPrefix2(String[] strs){
        Arrays.sort(strs);
        String first=strs[0],last=strs[strs.length-1];
        int i=0;
        for (; i < first.length() && i < last.length(); i++) {
            if (first.charAt(i)!=last.charAt(i))
                return first.substring(0,i);
        }
        return first;
    }
}
