package edu.LeetCode.PriorityQueue;

import org.junit.Test;

import java.util.PriorityQueue;

public class No4_MedianOfTwoSortedArrays {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int total = insertToHeap(nums2, insertToHeap(nums1, 0));
        return (total & 1) == 1 ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    private int insertToHeap(int[] nums, int count) {
        if (nums != null) {
            for (int num : nums) {
                count++;
                if ((count & 1) == 1) {
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                } else {
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
