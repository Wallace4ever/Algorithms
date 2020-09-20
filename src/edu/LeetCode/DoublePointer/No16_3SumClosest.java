package edu.LeetCode.DoublePointer;

import java.util.Arrays;

public class No16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int tempDistance = Math.abs(target - nums[i] - nums[left] - nums[right]);
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    sum = nums[i] + nums[left] + nums[right];
                }

                if (minDistance == 0) {
                    return sum;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sum;
    }
}
