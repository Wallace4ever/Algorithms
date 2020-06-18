package edu.LeetCode.Array;

import java.util.*;

/**
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 */
public class No1338_ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }
        Integer[] appearCount=map.values().toArray(new Integer[0]);
        Arrays.sort(appearCount);
        int minCount=1,appearance=0;
        for (int i = appearCount.length - 1; i >= 0; i--) {
            appearance+=appearCount[i];
            if (appearance>=arr.length/2)
                return minCount;
            minCount++;
        }
        return minCount;
    }
}
