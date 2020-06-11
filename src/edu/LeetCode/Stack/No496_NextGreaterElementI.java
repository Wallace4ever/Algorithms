package edu.LeetCode.Stack;

import java.util.*;

public class No496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1==null) return null;
        if (nums1.length==0) return new int[0];

        Deque<Integer> stack=new LinkedList<>();
        Map<Integer,Integer> hash=new HashMap<>();
        int[] result=new int[nums1.length];
        Arrays.fill(result,-1);

        for (int i=0;i<nums1.length;i++) {
            hash.put(nums1[i],i);
        }

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int num=stack.pop();
                if (hash.containsKey(num)) {
                    result[hash.get(num)]=nums2[i];
                }
            }
            stack.push(nums2[i]);
        }

        return result;
    }
}
