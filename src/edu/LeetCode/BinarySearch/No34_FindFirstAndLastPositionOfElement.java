package edu.LeetCode.BinarySearch;

public class No34_FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        int left=0,right=nums.length-1;
        while (left <= right) {
            int mid=left+((right-left)>>1);
            if (nums[mid] == target) {
                right=mid-1;//往左搜索，锁定右边界
            } else if (nums[mid] > target) {
                right=mid-1;
            } else if (nums[mid] < target) {
                left=mid+1;
            }
        }
        if (left < nums.length && nums[left] == target)
            result[0] = left;

        left=0;
        right=nums.length-1;
        while (left <= right) {
            int mid=left+((right-left)>>1);
            if (nums[mid] == target) {
                left=mid+1;//往右搜索，锁定左边界
            } else if (nums[mid] > target) {
                right=mid-1;
            } else if (nums[mid] < target) {
                left=mid+1;
            }
        }
        if (left > 0 && nums[left - 1] == target)
            result[1]=left-1;
        return result;
    }
}
