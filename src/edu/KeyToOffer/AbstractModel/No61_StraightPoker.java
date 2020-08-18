package edu.KeyToOffer.AbstractModel;

import org.junit.Test;

public class No61_StraightPoker {
    public boolean isStraight(int[] nums) {
        int[] hash = new int[14];
        for (int num : nums) {
            //发现有非零的对子直接返回false
            if (++hash[num] != 1 && num != 0)
                return false;
        }
        //这里已经保证数组中除0外的牌最多只有一张，找到顺子数值的左右边界
        int min = 0, max = 0;
        for (int i = 1; i < 14; i++) {
            if (min == 0 && hash[i] != 0)
                min = i;
            if (hash[i] != 0)
                max = i;
        }
        int nonZero = nums.length - hash[0];
        //max和min之间有max-min-1个空位需要填满，已有nonZero-2个非0数，还有hash[0]个0
        if (max - min - 1 > nonZero - 2 + hash[0])
            return false;
        return true;
    }

    @Test
    public void test() {
        System.out.println(isStraight(new int[]{0,0,0,0,0}));
    }
}
