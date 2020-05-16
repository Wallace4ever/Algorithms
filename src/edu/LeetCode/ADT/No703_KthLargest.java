package edu.LeetCode.ADT;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 */
public class No703_KthLargest {
    private int capacity;
    PriorityQueue<Integer> pq;

    /**
     * 第K大则使用最小堆（第k小则使用最大堆，需在构造优先队列时传入自定义比较器）
     * @param k 堆的逻辑容量，保证堆中剩余K-1个元素都大于堆顶，则堆顶为第K大
     * @param nums 初始化存入堆中的数组
     */
    public No703_KthLargest(int k, int[] nums) {
        capacity=k;
        pq=new PriorityQueue<>();
        for (int val : nums) {
            add(val);
        }
    }

    /**
     * 每次插入新元素时，若堆不满则直接插入，若满了则比较堆顶元素和要插入的元素大小，只有在比堆顶大时才将堆顶元素删除并插入新值
     * 插入后自动堆化，堆顶为新的第K大元素
     * @param val 要插入的值
     * @return 堆顶元素（当前第K大的数）
     */
    public int add(int val) {
        if (pq.size() < capacity) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
