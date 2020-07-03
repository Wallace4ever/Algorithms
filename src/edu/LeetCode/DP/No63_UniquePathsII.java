package edu.LeetCode.DP;


public class No63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y=obstacleGrid.length,x=obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1||obstacleGrid[y-1][x-1]==1) return 0;
        int[] path=new int[x];
        boolean flag=true;
        for (int i = 0; i < x; i++) {
            path[i]=(flag&&(flag=obstacleGrid[0][i]==0))?1:0;
        }
        flag=true;
        for (int i = 1; i < y; i++) {
            path[0]=(flag&&(flag=obstacleGrid[i][0]==0))?1:0;
            for (int j = 1; j < x; j++) {
                path[j]=obstacleGrid[i-1][j]==0?path[j]:0;
                path[j]+=obstacleGrid[i][j-1]==0?path[j-1]:0;
            }
        }
        return path[x-1];
    }
}
