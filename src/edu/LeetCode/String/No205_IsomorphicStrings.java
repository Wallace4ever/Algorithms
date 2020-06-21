package edu.LeetCode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。你可以假设 s 和 t 具有相同的长度。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 */
public class No205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return oneDirection(s, t) && oneDirection(t, s);
    }

    private boolean oneDirection(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si=s.charAt(i),ti=t.charAt(i);
            if (!map.containsKey(si)){
                map.put(si, ti);
            } else if (map.get(si)!=ti){
                return false;
            }
        }
        return true;
    }
}
