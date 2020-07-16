package edu.LeetCode.Stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                int operator2 = stack.pop(), operator1 = stack.pop();
                int ans=0;
                switch (token) {
                    case "+":
                        ans = operator1 + operator2;
                        break;
                    case "-":
                        ans = operator1 - operator2;
                        break;
                    case "*":
                        ans = operator1 * operator2;
                        break;
                    case "/":
                        ans = operator1 / operator2;
                        break;
                }
                stack.push(ans);
            }
        }
        return stack.peek();
    }

    @Test
    public void test() {
        String[] strings={"2","1","+","3","*"};
        System.out.println(evalRPN(strings));
    }
}