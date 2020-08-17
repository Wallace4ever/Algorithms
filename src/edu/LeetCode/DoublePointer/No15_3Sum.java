package edu.LeetCode.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j + 1 < k && nums[j + 1] == nums[j])
                        j++;
                    j++;
                    while (k - 1 > j && nums[k - 1] == nums[k])
                        k--;
                    k--;
                }
                if (nums[j] + nums[k] > -nums[i]) {
                    while (k - 1 > j && nums[k - 1] == nums[k])
                        k--;
                    k--;
                }
                if (nums[j] + nums[k] < -nums[i]){
                    while (j + 1 < k && nums[j + 1] == nums[j])
                        j++;
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
            i++;
        }
        return result;
    }
}
