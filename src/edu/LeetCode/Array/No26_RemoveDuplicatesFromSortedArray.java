package edu.LeetCode.Array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class No26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow=0,fast;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]!=nums[slow]){
                nums[++slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
