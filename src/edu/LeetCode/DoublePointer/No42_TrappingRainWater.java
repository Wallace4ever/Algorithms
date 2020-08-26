package edu.LeetCode.DoublePointer;

import org.junit.Test;

public class No42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            int currWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (currWater > 0) total += currWater;
        }
        return total;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;
        int n = height.length, total = 0;
        int left = 0, right = n - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax)
                total += leftMax - height[left++];
            else
                total += rightMax - height[right--];
        }
        return total;
    }

    @Test
    public void test() {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
