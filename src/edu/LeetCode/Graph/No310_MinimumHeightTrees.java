package edu.LeetCode.Graph;

import org.junit.Test;

import java.util.*;

public class No310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> list=new ArrayList<>();
            list.add(0);
            return list;
        }

        //出度表
        int[] degree = new int[n];
        //邻接表，使用map而不是数组的原因是为了便于在后面删除节点，并且能快速获得剩余节点数
        Map<Integer,Set<Integer>> adjacency = new HashMap<>();
        //填充出度表和邻接表
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;

            Set<Integer> set = adjacency.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            adjacency.put(edge[0],set);
            set = adjacency.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            adjacency.put(edge[1],set);
        }

        //使用队列来约束一轮只删除当前出度为1的节点，因为一轮删除过程中可能会有下一轮的点的出度变为1
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (adjacency.size()>2) {
            //当前轮要删除的节点数
            int size = queue.size();
            while (size-- > 0) {
                //每轮中出度为1的节点就是当前树的叶子节点
                Integer leaf=queue.poll();
                for (Integer integer : adjacency.get(leaf)) {
                    //把要删除的节点的所有邻居出度减一，如果发现出度变为1要放入下一轮处理
                    if (--degree[integer] == 1) {
                        queue.offer(integer);
                    }
                }
                adjacency.remove(leaf);
            }
        }
        return new ArrayList<>(adjacency.keySet());
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{0,1}, {0, 2},{0,3},{4,3},{5,4}};
        findMinHeightTrees(6, arr).forEach(System.out::println);
    }
}
