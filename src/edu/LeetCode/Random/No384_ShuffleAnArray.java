package edu.LeetCode.Random;

import java.util.Random;

public class No384_ShuffleAnArray {
    private int[] original;
    private int[] result;
    private Random rand = new Random();
    private final int n;

    public No384_ShuffleAnArray(int[] nums) {
        original = nums.clone();
        result = nums;
        n = nums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        result = original;
        original = original.clone();
        return result;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        result = original;
        original = original.clone();
        for (int i = 0; i < n; i++) {
            int randomBorder = rand.nextInt(n - i) + i;
            int temp=result[i];
            result[i] = result[randomBorder];
            result[randomBorder] = temp;
        }
        return result;
    }
}
