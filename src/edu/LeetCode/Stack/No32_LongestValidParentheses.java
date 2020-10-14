package edu.LeetCode.Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class No32_LongestValidParentheses {
    //栈解法，特殊之处在于用栈底表示最后一次没有被匹配的右括号下标，栈中其余元素都是左括号的下标
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length(), maxLength = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') { //如果是左括号就将其下标入栈
                stack.push(i);
            } else { //如果是右括号就尝试从栈顶弹出距离其最近的左括号
                stack.pop();
                //如果弹出能匹配的左括号后栈中还有元素则该元素表示前一个弹出的左括号左边的那个字符
                //（左边的那个字符可能是左括号也可能是最后一次没有被匹配的右括号）
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else { //否则栈底表示最后一次没有被匹配的右括号下标，我们知道当前位置i上的右括号是没有匹配的的
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

    //动态规划解法
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length(), max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            //如果当前位置是左括号那么必然不可能是一个完整括号对的结尾，默认为0不用处理
            if (s.charAt(i) == ')')
                //如果前一个位置是左括号那么直接组成一个括号对，长度在dp[i - 2]（如果存在的话）的基础上加2即可
                if (s.charAt(i - 1) == '(')
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;

                //否则前一个位置是右括号就需要根据dp[i - 1]找到前面对应位置X
                //如果前面对应位置X有和第i个位置匹配的左括号
                else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                                            //那么在dp[i] = dp[i - 1] + 2的基础上还要记得加上X左边可能的连续括号对长度
                    dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                //否则前面没法找到一个合适的左括号与当前第i个位置的')'组成合法的括号对，那么dp[i]默认为0
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    @Test
    public void test() {
        System.out.println(longestValidParentheses("))"));
    }
}
