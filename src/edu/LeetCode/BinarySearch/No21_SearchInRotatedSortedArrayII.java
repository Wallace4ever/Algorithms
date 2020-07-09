package edu.LeetCode.BinarySearch;

public class No21_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left < right && nums[left] == nums[right]){
            if(nums[left]==target) return true;
            left++;
            right--;
        }
        while (left <= right) {
            int mid=left+((right-left)>>1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {//如果左边有序，注意=的特例
                if (nums[left] <= target && nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {//如果右边有序
                if (nums[right] >= target && nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
