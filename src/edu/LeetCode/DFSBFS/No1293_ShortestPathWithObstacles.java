package edu.LeetCode.DFSBFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class No1293_ShortestPathWithObstacles {
    public int shortestPath(int[][] grid, int k) {
        final int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  //{0, 1}, {0, -1}, {1, 0}, {-1, 0}    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        int m = grid.length, n = grid[0].length, step = 0;
        k = Math.min(k, m + n - 3);
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, k));
        visited[0][0][k] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point cur = queue.poll();
                if (cur.x == m - 1 && cur.y == n - 1) return step;
                for (int[] dir : direction) {
                    int i = cur.x + dir[0], j = cur.y + dir[1];
                    if (0 > i || i >= m || 0 > j || j >= n) continue;
                    int rest = cur.remain - grid[i][j];
                    if (rest >= 0 && !visited[i][j][rest]) {
                        visited[i][j][rest] = true;
                        queue.offer(new Point(i, j, cur.remain - grid[i][j]));
                    }
                }
            }
            step++;
        }
        return -1;
    }

    class Point{
        int x;
        int y;
        int remain;

        public Point(int x, int y, int remain) {
            this.x = x;
            this.y = y;
            this.remain = remain;
        }
    }

    @Test
    public void test() {
        int[][] arr= new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,1,1,1,1,1,1,1},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,1,1,1,1,1,1,1},
                {0,1,0,1,1,1,1,0,0,0},
                {0,1,0,0,0,0,0,0,1,0},
                {0,1,1,1,1,1,1,0,1,0},
                {0,0,0,0,0,0,0,0,1,0}};
        System.out.println(shortestPath(arr,3));
    }
}
