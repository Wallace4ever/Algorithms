package edu.LeetCode.Math;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给出正整数区间[a,b]，找出区间中每一个字面不含 3 5 8 的数字的总数
 */
public class ByteDanceInterview3 {
    public int getCount(int a, int b) {
        int indexA = 0, indexB = 0;
        int[] arrA = new int[10], arrB = new int[10];
        while ( a > 0) {
            arrA[indexA++] = a % 10;
            a /= 10;
        }
        while ( b > 0) {
            arrB[indexB++] = b % 10;
            b /= 10;
        }
        return getCountFrom0(arrB, indexB - 1) - getCountFrom0(arrA, indexA - 1) + 1;
    }

    private int getCountFrom0(int[] arr, int index) {
        int result = 0;
        while (index >= 0) {
            int qualifiedNumbers = 0;
            if (arr[index] < 3)
                qualifiedNumbers = arr[index];
            else if (arr[index] < 5)
                qualifiedNumbers = arr[index] - 1;
            else if (arr[index] < 8)
                qualifiedNumbers = arr[index] - 2;
            else
                qualifiedNumbers = arr[index] - 3;
            result += qualifiedNumbers * (int) Math.pow(7, index);

            if (arr[index] == 3 || arr[index] == 5 || arr[index] == 8)
                Arrays.fill(arr, 0, index, 9);
            index--;
        }
        return result + 1;
    }

    @Test
    public void test() {
        System.out.println(getCount(1,14));
    }
}