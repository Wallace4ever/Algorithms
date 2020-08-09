package edu.KeyToOffer.OptimizeTime;

import org.junit.Test;

import java.util.Arrays;

public class ConcatArrayAsMinNumber {
    public String PrintMinNumber(int [] numbers) {
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums,(a,b)->(a+b).compareTo(b+a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
}
