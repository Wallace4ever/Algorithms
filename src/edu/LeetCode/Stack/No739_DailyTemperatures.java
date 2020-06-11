package edu.LeetCode.Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class No739_DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        if (T==null||T.length==0) return null;
        Deque<Integer> stack = new LinkedList<>();
        int[] wait = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                wait[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return wait;
    }

    public static void main(String[] args) {
        int[] a={73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(a)));
    }
}
