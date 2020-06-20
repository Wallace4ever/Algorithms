package edu.LeetCode.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class No151_ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> list=Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }
}
