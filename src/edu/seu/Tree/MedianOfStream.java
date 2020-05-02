package edu.seu.Tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianOfStream {
    private int count=0;
    PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue=new PriorityQueue<>(15,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void Insert(Integer num) {
        if (count%2==0){
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        }else{
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count%2==1)
            return (double) minQueue.peek();
        else
            return ((double)minQueue.peek()+(double)maxQueue.peek())/2;
    }
}
