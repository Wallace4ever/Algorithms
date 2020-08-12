package edu.LeetCode.DoublePointer;

public class No11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = height[left] < height[right] ?
                    Math.max(max, (right - left) * height[left++]) :
                    Math.max(max, (right - left) * height[right--]) ;
        }
        return max;
    }
}
