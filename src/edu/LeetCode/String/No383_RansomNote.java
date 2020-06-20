package edu.LeetCode.String;

/**
 * 定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。你可以假设两个字符串均只含有小写字母。
 */
public class No383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash =new int[26];
        for(int i=0;i<magazine.length();i++){
            hash[(int)magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(--hash[(int)ransomNote.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
