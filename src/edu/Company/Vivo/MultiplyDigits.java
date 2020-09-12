package edu.Company.Vivo;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 */
public class MultiplyDigits {
    private Deque<Integer> stack = new LinkedList<>();
    private boolean canDo = true;
    public int solution (int n) {
        cal(n);
        if (canDo) {
            int result = 0;
            while (!stack.isEmpty())
                result = result * 10 + stack.pop();
            return result;
        } else {
            return -1;
        }
    }

    private void cal(int n) {
        if (n < 10) {
            stack.push(n);
            return;
        }
        for (int i = 9; i >= 2; i--) {
            if (n % i == 0) {
                stack.push(i);
                cal(n / i);
                return;
            }
        }
        canDo = false;
    }

    @Test
    public void test() {
        System.out.println(solution(100));
    }
}
