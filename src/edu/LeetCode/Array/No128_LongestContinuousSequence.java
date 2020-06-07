package edu.LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class No128_LongestContinuousSequence{
    public int longestConsecutive(int[] nums) {
    Set<Integer> set=new HashSet<>();
    for(int n:nums){
        set.add(n);
    }
    int maxLen=0;
    for(int n:nums){
        if(!set.contains(n-1)){
            int currentLen=1;
            while(set.contains(++n)){
                currentLen++;
            }
            maxLen=Math.max(maxLen,currentLen);
        }
    }
    return maxLen;
    }
}