package edu.KeyToOffer.Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack {
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();
    boolean useQ1AsTemp=true;

    public void push(int node) {
        if (useQ1AsTemp) {
            queue1.offer(node);
        } else {
            queue2.offer(node);
        }
    }

    public int pop() {
        if (useQ1AsTemp) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            useQ1AsTemp=false;
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            useQ1AsTemp=true;
            return queue2.poll();
        }
    }
}
