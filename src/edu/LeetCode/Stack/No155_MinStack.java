package edu.LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No155_MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> helperStack;
    public No155_MinStack() {
        mainStack = new ArrayDeque<>();
        helperStack = new ArrayDeque<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (helperStack.size()==0||x<=helperStack.peek())
            helperStack.push(x);
    }

    public void pop() {
        int x= mainStack.pop();
        if (helperStack.size()!=0&&x==helperStack.peek())
            helperStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return helperStack.peek();
    }
}
