package edu.LeetCode.Array;

import org.junit.Test;

import java.util.HashMap;

public class No560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> appearCount = new HashMap<>();
        int preSum = 0, count = 0;
        appearCount.put(0, 1);
        for (int num : nums) {
            preSum += num;
            count += appearCount.getOrDefault(preSum - k, 0);
            appearCount.put(preSum, appearCount.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
