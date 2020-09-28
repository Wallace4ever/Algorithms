package edu.LeetCode.Math;

import org.junit.Test;

public class No29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isDividendPositive = dividend > 0, isDivisorPositive = divisor > 0;
        if (isDividendPositive) dividend = -dividend;
        if (isDivisorPositive) divisor = -divisor;
        int times = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            times++;
        }
        return isDividendPositive ^ isDivisorPositive ? -times : times;
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean dPositive = dividend > 0, rPositive = divisor > 0;
        if (dPositive) dividend = -dividend;
        if (rPositive) divisor = -divisor;

        int times = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int count = 1;
            while (dividend - temp <= temp) {
                temp += temp;
                count += count;
            }
            times += count;
            dividend -= temp;
        }

        return dPositive ^ rPositive ? -times : times;
    }

    @Test
    public void test() {
        System.out.println(divide2(-2147483648,2));

    }
}
