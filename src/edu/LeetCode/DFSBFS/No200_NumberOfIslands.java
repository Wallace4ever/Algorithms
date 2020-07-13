package edu.LeetCode.DFSBFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class No200_NumberOfIslands {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j]='2';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                dfs(grid, x, y);
            }
        }
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * grid[0].length + j);
        while (!queue.isEmpty()) {
            int id=queue.poll();
            int row = id / grid[0].length, col = id % grid[0].length;
            grid[row][col]='2';
            for (int[] dir : dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == '1') {
                    queue.offer(x * grid[0].length + y);
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {
                '0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
