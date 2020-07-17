package edu.LeetCode.PriorityQueue;

import org.junit.Test;

import java.util.*;

public class No347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //统计频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        //小顶堆排序
        Queue<Integer> heap = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for (Integer num : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (map.get(num) > map.get(heap.peek())) {
                heap.poll();
                heap.offer(num);
            }
        }

        //输出结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=heap.poll();
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        //统计频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        //创建桶，以数字为桶的值，以频次为桶的下标，使用List以防有多个频次相同的数
        //一个数最多出现N次，则桶数组的长度为N+1（为了使用方便）
        List<Integer>[] buckets=new List[nums.length+1];
        map.forEach((key,value)->{
            if (buckets[value]==null)
                buckets[value]=new ArrayList<>();
            buckets[value].add(key);
        });

        //从后向前把所有非空的桶中所有的数往结果数组中填充，当结果数组已满时停止填充
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (buckets[i] != null) {
                for (Integer num : buckets[i]) {
                    if (index >= k)
                        break;
                    res[index++] = num;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(topKFrequent2(new int[]{4,1,-1,2,-1,2,3},2)));
    }
}
