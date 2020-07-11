package edu.LeetCode.Matrix;

public class No59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int left = 0, right = n - 1, up = 0, down = n - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                matrix[up][col] = count++;
            }
            if (++up > down) break;

            for (int row = up; row <= down; row++) {
                matrix[row][right] = count++;
            }
            if (--right < left) break;

            for (int col = right; col >= left; col--) {
                matrix[down][col] = count++;
            }
            if (--down < up) break;

            for (int row = down; row >= up; row--) {
                matrix[row][left] = count++;
            }
            if (++left > right) break;
        }
        return matrix;
    }
}
