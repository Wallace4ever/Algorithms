package edu.KeyToOffer.OptimizeTime;

import java.util.PriorityQueue;

public class MedianOfStream {
    private int count=0;
    PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue=new PriorityQueue<>((o1, o2) -> o2-o1);

    public void Insert(Integer num) {
        if ((count & 1) == 0) {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 1) == 1)
            return (double) minQueue.peek();
        else
            return ((double)minQueue.peek()+(double)maxQueue.peek())/2;
    }
}
