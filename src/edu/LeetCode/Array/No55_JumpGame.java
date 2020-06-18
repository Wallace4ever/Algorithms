package edu.LeetCode.Array;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。
 */
public class No55_JumpGame {
    public boolean canJump(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            } else {
                max=Math.max(max,i+nums[i]);
                if (max>=nums.length) return true;
            }
        }
        //nums.length==0的情况
        return true;
    }
}
