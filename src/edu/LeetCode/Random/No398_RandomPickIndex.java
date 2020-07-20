package edu.LeetCode.Random;

import java.util.Random;

public class No398_RandomPickIndex {
    private final int[] nums;
    private final Random random = new Random();

    public No398_RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        //index用于选取最终要返回的下标，appearance用于保存目标数已经出现的次数
        int index = 0, appearance = 0;
        for (int i = 0; i < nums.length; i++) {
            //以出现的目标数为蓄水池中的元素
            if (nums[i] == target) {
                appearance++;
                if (random.nextInt(appearance)+1==1)
                    index=i;
            }
        }
        return index;
    }
}
