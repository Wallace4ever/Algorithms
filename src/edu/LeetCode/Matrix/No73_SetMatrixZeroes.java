package edu.LeetCode.Matrix;

import java.util.HashSet;
import java.util.Set;

public class No73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix==null) return;
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i)||cols.contains(j))
                    matrix[i][j]=0;
            }
        }
    }
}
