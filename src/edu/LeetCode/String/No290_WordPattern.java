package edu.LeetCode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。例如：
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */
public class No290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern==null||str==null||pattern.length()==0||str.length()==0) return false;
        String[] strs=str.split(" ");
        String[] patterns=pattern.split("");
        return match(strs,patterns)&&match(patterns,strs);
    }

    private boolean match(String[] a, String[] b) {
        if (a.length!=b.length) return false;
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], b[i]);
            } else if (!map.get(a[i]).equals(b[i])){
                return false;
            }
        }
        return true;
    }
}
