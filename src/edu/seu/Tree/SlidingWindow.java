package edu.seu.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        //初始化结果集不满足计算条件时直接返回
        ArrayList<Integer> result=new ArrayList<>();
        if (num==null||num.length==0||size<=0||size>num.length)
            return result;
        //使用大顶堆来模拟滑动窗口
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //填入初始值
        for (int i=0;i<size;i++){
            pq.offer(num[i]);
        }
        //之后每次取堆顶到结果集，加入下一个元素并移除滑动窗口最左元素
        //PriorityQueue相较于Queue接口重载了Remove方法，可以指定元素删除，如果堆中有多个相同元素则删除其中一个
        int index=size;
        while (index<num.length) {
            result.add(pq.peek());
            pq.offer(num[index]);
            pq.remove(num[index-size]);
            index++;
        }
        result.add(pq.peek());
        return result;
    }
}
