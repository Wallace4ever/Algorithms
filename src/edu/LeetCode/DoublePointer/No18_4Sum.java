package edu.LeetCode.DoublePointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target || nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target || nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target)
                    continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2 }, -9);
        lists.forEach((a)->{
            a.forEach(b-> System.out.print(b+" "));
            System.out.println();
        });
    }
}
