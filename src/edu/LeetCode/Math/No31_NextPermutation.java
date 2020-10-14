package edu.LeetCode.Math;

public class No31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;

        //找到目标位置i
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        //从后往前搜索递减的部分，找到首个大于nums[i]的数，并和nums[i]交换
        if (i >= 0) {
            int k = n - 1;
            //这里可以用二分查找进行优化
            while (nums[k] <= nums[i])
                k--;
            swap(nums, i, k);
        }

        //把剩余一定是递减的部分交换成递增的
        for (int left = i + 1, right = n - 1; left < right; left++, right--) {
            swap(nums, left, right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
