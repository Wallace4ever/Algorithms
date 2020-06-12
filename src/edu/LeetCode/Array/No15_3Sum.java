package edu.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class No15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null||nums.length<3)
            return new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0]>0)
            return new ArrayList<>();

        List<List<Integer>> lists=new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            if (left>0&&nums[left]==nums[left-1]) continue;
            int target=-nums[left];
            int right=nums.length-1;
            for (int mid = left + 1; mid < nums.length - 1; mid++) {
                if (mid>left+1&& nums[mid]==nums[mid-1]) continue;
                while (mid < right && nums[mid] + nums[right] > target) {
                    --right;
                }
                if (mid==right) break;
                if (nums[mid] + nums[right] == target) {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    lists.add(list);
                }
            }

        }
        return lists;
    }
}
