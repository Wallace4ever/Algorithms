package edu.LeetCode.BinarySearch;

public class No35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums==null||nums.length==0) return 0;
        int left=0,right=nums.length-1;
        while (left <= right) {
            int mid=left+((right-left)>>1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[]num=new int[]{1,3,5,6};
        System.out.println(searchInsert(num,7));
    }
}
