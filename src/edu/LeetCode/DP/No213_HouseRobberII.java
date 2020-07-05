package edu.LeetCode.DP;

import java.util.Arrays;

public class No213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(rob2(Arrays.copyOfRange(nums,0,nums.length-1)),rob2(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int rob2(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int n=nums.length;
        if(n==1) return nums[0];
        for (int i = 2; i < n; i++) {
            if (i == 2) {
                nums[i] += nums[0];
            } else {
                nums[i]+=Math.max(nums[i-2],nums[i-3]);
            }
        }
        return Math.max(nums[n-1],nums[n-2]);
    }
}
