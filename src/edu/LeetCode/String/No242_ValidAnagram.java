package edu.LeetCode.String;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class No242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(getHash(s),getHash(t));
    }

    private int[] getHash(String s) {
        int[] hash=new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }
}
