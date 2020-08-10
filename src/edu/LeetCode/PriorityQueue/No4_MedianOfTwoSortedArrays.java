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

class BS_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) return singleArray(nums2);
        if (nums2 == null) return singleArray(nums1);
        int len1 = nums1.length, len2 = nums2.length;
        int leftMedian = (len1 + len2 + 1) / 2, rightMedian = (len1 + len2 + 2) / 2;
        return 0.5 * (getKthNum(nums1, 0, len1 - 1, nums2, 0, len2 - 1, leftMedian) +
                getKthNum(nums1, 0, len1 - 1, nums2, 0, len2 - 1, rightMedian));
    }

    private double singleArray(int[] array) {
        int len = array.length;
        if ((len & 1) == 1)
            return array[len / 2];
        else
            return (array[len / 2] + array[len / 2 - 1]) / 2.0;
    }

    private int getKthNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int range1 = end1 - start1 + 1, range2 = end2 - start2 + 1;
        //保证nums1一定是搜索范围更小的那个
        if (range1 > range2) return getKthNum(nums2, start2, end2, nums1, start1, end1, k);
        if (range1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int last1 = start1 + Math.min(range1, k / 2) - 1, last2 = start2 + Math.min(range2, k / 2) - 1;
        if (nums1[last1] < nums2[last2])
            return getKthNum(nums1, last1 + 1, end1, nums2, start2, end2, k - (last1 - start1 + 1));
        else
            return getKthNum(nums1, start1, end1, nums2, last2 + 1, end2, k - (last2 - start2 + 1));
    }
}