package edu.LeetCode.TopologicalSort;
import java.util.*;

public class No210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //邻接表
        List<Integer>[] adjacency = new List[numCourses];
        //入度统计表
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adjacency[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }

        //BFS用到的队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        /*
          用数组按出队列顺序保存元素
         */
        int[] result=new int[numCourses];
        int index=0;
        //BFS拓扑排序
        while (!queue.isEmpty()) {
            //"删除"入度为0的点temp
            int temp = queue.poll();
            result[index++]=temp;
            numCourses--;
            for (int i : adjacency[temp]) {
                //temp的邻接点如果入度-1后为0则放入队列中
                if (--inDegree[i] == 0)
                    queue.offer(i);
            }
        }
        //如果存在环则一定有节点的入度始终不为0
        return numCourses == 0?result:new int[0];
    }
}

class SolutionII {
    /*
     * 用栈在回溯时保存访问过的节点，最终出栈的顺序也是拓扑排序
     */
    Deque<Integer> stack = new ArrayDeque<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //邻接表
        List<Integer>[] adjacency = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adjacency[pre[1]].add(pre[0]);
        }

        //访问状态表
        int[] status = new int[numCourses];
        //不需要刻意从入度为0的点开始DFS因为访问过就会标记为-1，而遇到-1就会直接返回
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(status,adjacency,i)) return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=stack.pop();
        }
        return result;
    }

    private boolean dfs(int[] status, List<Integer>[] adjacency, int currentVisit) {
        //回溯终止条件
        if (status[currentVisit]==-1) return true;
        if (status[currentVisit]==1) return false;

        //做选择
        status[currentVisit]=1;
        for (int neighbour : adjacency[currentVisit]) {
            if (!dfs(status,adjacency,neighbour)) return false;
        }
        //撤销选择
        status[currentVisit] = -1;
        stack.push(currentVisit);
        return true;
    }
}