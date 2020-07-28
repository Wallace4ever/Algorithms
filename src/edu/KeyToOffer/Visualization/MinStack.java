package edu.KeyToOffer.Visualization;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> mainStack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int node) {
        if (minStack.isEmpty()||node<=minStack.peek()){
            minStack.push(node);
        }
        mainStack.push(node);
    }

    public void pop() {
        int node = mainStack.pop();
        if (!minStack.isEmpty() && minStack.peek() == node) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.isEmpty() ? 0 : mainStack.peek();
    }

    public int min() {
        return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peek();
    }
}
