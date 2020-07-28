package edu.KeyToOffer.Visualization;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class PushPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushA.length, pushIndex = 0;
        outer:
        for (int i = 0; i < n; i++) {
            //如果栈顶元素和当前要弹出的值相同则弹出，开始下一次循环
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
                continue;
            }
            //否则直到找到和当前元素相同的值之前，依次将pushA中的元素入栈
            while (pushIndex < n) {
                stack.push(pushA[pushIndex++]);
                //如果发现压入的值和popA当前要弹出的值相同，就在保持i不变的情况下继续下一次外层循环
                if (pushA[pushIndex-1] == popA[i]){
                    i--;
                    continue outer;
                }
            }
            //如果pushA的元素全部入栈都没有和pop[i]相同的
            return false;
        }
        //最后的情况是所有元素都正确入栈、和popA吻合、出栈，由第一个continue后i==n，正常结束for循环而没有提前返回false
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}
