package edu.LeetCode.ADT;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        int[] result = new int[n - k + 1];
        MonotonicQueue<Integer> queue = new MonotonicQueue<>();
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                queue.enqueue(nums[i]);
            } else {
                queue.enqueue(nums[i]);
                result[index++] = queue.getMax();
                queue.dequeue(nums[i - k + 1]);
            }
        }
        return result;
    }

    private class MonotonicQueue<v extends Comparable<v>>{
        private Deque<v> deque = new LinkedList<>();

        public void enqueue(v value) {
            while (!deque.isEmpty() && deque.peekLast().compareTo(value) < 0) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public void dequeue(v value) {
            if (value.equals(deque.peekFirst()))
                deque.pollFirst();
        }

        public v getMax() {
            return deque.peekFirst();
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
