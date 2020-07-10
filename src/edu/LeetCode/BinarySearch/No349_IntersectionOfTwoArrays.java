package edu.LeetCode.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No349_IntersectionOfTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i:nums1){
            n1.add(i);
        }
        for(int i:nums2){
            if(n1.contains(i))
                result.add(i);
        }
        int[] ans=new int[result.size()];
        int index=0;
        for (Integer i : result) {
            ans[index++]=i;
        }
        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        for (int target : nums2) {
            if (Arrays.binarySearch(nums1, target)>=0) {
                result.add(target);
            }
        }
        int[] ans=new int[result.size()];
        int index=0;
        for (Integer i : result) {
            ans[index++]=i;
        }
        return ans;
    }
}
