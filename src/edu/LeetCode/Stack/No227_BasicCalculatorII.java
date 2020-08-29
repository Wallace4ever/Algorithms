package edu.LeetCode.Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class No227_BasicCalculatorII {
    Map<Integer, Integer> brackets = new HashMap<>();

    public int calculate(String s) {
        //将左右括号的对应关系存入map，避免后面重复计算
        findMatchingBrackets(s);
        return calculate(s, 0, s.length() - 1);
    }

    private int calculate(String s, int start, int end) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { //如果是数字就转化并暂存到num中
                num = num * 10 + (c - '0');
            } else if (c == '(') { //如果是左括号，那么查找对应右括号的位置并递归计算左右括号间表达式的值
                int rightBracket = brackets.get(i);
                num = calculate(s, i + 1, rightBracket - 1);
                //把处理到的位置设为右括号的位置
                i = rightBracket;
            }
            if ((!Character.isDigit(c) && c != ' ') || i == end) {//如果是运算符或者到了结尾就将已经得到的num入栈，跳过空格等不相关字符
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                //重置num并更新sign为当前运算符，到了结尾运算符就不会再用了
                sign = c;
                num = 0;
            }
        }
        int answer = 0;
        while (!stack.isEmpty())
            answer += stack.pop();
        return answer;
    }

    private void findMatchingBrackets(String s) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                brackets.put(stack.pop(), i);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(calculate("(3+ 2)*  (1-2) "));
    }
}
