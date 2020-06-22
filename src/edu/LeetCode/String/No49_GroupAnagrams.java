package edu.LeetCode.String;

import java.util.*;

public class No49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map =new HashMap<>();
        for (String str : strs) {
            int hashcode = Arrays.hashCode(getHash(str));
            if (!map.containsKey(hashcode)) {
                map.put(hashcode, new ArrayList<>());
            }
            map.get(hashcode).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private int[] getHash(String s) {
        int[] hash = new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(new String("text").hashCode());
        System.out.println(new String("text").hashCode());
        System.out.println(new int[]{1,2}.hashCode());
        System.out.println(new int[]{1,2}.hashCode());
        System.out.println(Arrays.hashCode(new int[]{1, 2}));
        System.out.println(Arrays.hashCode(new int[]{1, 2}));
    }
}
