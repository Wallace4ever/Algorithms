package edu.LeetCode.BitManipulation;

public class Interview1704MissingNumber {
    //异或方法，只有消失的数单个出现，其他数的值和下标各出现一次
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        result ^= n;
        for (int i = 0; i < n; i++) {
            result ^= (i ^ nums[i]);
        }
        return result;
    }

    //数学方法，求和公式减去元素总和
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result += (i - nums[i]);
        }
        return result;
    }
}
