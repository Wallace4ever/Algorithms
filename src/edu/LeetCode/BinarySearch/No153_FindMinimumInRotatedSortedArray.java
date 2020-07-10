package edu.LeetCode.BinarySearch;

public class No153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findMin2(int[] nums) {
        int left=0,right=nums.length-1;
        while (left <= right) {
            //实际上最终left==right时就返回了，不会跳出循环
            if (nums[left]<=nums[right])
                return nums[left];
            int mid=left+((right-left)>>1);
            if (nums[mid] >= nums[left]) {//如果左侧有序（单调增），则最小值一定在右侧
                left=mid+1;
            } else if (nums[mid] < nums[left]) {//左侧不是单调增，最小值在左侧（不排除mid）
                right=mid;
            }
        }
        return -1;
    }
}
