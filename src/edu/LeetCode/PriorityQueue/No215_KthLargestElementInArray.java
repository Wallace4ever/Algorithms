package edu.LeetCode.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No215_KthLargestElementInArray {
    public int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest1(int[] nums, int k) {
        //大顶堆nlogn
        Queue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for (int num : nums) {
            heap.offer(num);
        }
        int result=0;
        for (int i = 1; i <= k; i++) {
            result = heap.poll();
        }
        return result;
    }

    public int findKthLargest2(int[] nums, int k) {
        //小顶堆nlogk
        Queue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }
}
