package edu.LeetCode.Matrix;

public class No329_LongestIncreasingPathInAMatrix {
    //存储要dfs的方向，使用数组来简化代码
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, cols;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        int max=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, result));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col, int[][]result) {
        if(result[row][col]!=0) return result[row][col];
        for (int[] dir : directions) {
            int x = row + dir[0], y = col + dir[1];
            if (0 <= x && x < rows && 0 <= y && y < cols && matrix[row][col] < matrix[x][y]) {
                result[row][col] = Math.max(result[row][col], dfs(matrix, x, y, result));
            }
        }
        return ++result[row][col];
    }
}
