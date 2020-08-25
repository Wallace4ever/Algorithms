package edu.LeetCode.Math;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 给出使用快速乘+递归+短路逻辑运算符的方法。
 */
public class OneAddToN {
    public int sumNums(int n) {
        return multiply(n, n + 1) >> 1;
    }

    private int multiply(int n, int m){
        boolean b = (n > 1) && (((n & 1) == 1 && (m = m + multiply(n >> 1, m << 1)) > 0) || ((n & 1) == 0) && (m = multiply(n >> 1, m << 1)) > 0);
        return m;
    }
}
