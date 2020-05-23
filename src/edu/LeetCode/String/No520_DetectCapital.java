package edu.LeetCode.String;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 */
public class No520_DetectCapital {
    //使用了String类自带的方法，其实还有更多种做法
    public boolean detectCapitalUse(String word) {
        if (word==null||word.length()==0) return false;
        if (word.equals(word.toUpperCase())||word.equals(word.toLowerCase()))
            return true;
        StringBuilder normal=new StringBuilder(word.toLowerCase());
        normal.setCharAt(0,(char)(normal.charAt(0)-32));
        return normal.toString().equals(word);
        //return  word.equals(word.toLowerCase())||word.equals(word.toUpperCase())||word.equals(Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase());
    }
}