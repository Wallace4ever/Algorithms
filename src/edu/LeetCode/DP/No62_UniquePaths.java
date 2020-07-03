package edu.LeetCode.DP;

import java.util.Arrays;

public class No62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

    public int uniquePaths2(int m, int n) {
        if(m==1||n==1) return 1;
        int[][] path=new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0]=1;
        }
        for (int j = 0; j < n; j++) {
            path[0][j]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }

    public int uniquePaths3(int m, int n) {
        if(m==1||n==1) return 1;
        int min=Math.min(m,n);
        int max=Math.max(m,n);
        int[] path=new int[min];
        Arrays.fill(path,1);
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                path[j]=path[j]+path[j-1];
            }
        }
        return path[min-1];
    }
}
