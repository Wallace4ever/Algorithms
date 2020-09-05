package edu.LeetCode.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51_NQuenes {
    private List<List<String>> resultSet = new ArrayList<>();
    private int n = 0;
    //使用三个变量作为bitSet记录每列、每个对角线、每个反对角线上是否已经出现过皇后
    private int columns = 0, diagonals = 0, reverseDiag = 0;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0, new ArrayList<>());
        return resultSet;
    }

    private void backtrack(int row, List<String> path) {
        //递归终止条件，添加到结果集
        if (row == n) {
            resultSet.add(new ArrayList<>(path));
            return;
        }

        //每行只选择一个点
        for (int i = 0; i < n; i++) {
            //剪枝，只对满足条件的点进行递归
            if (check(row, i)) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                path.add(new String(str));
                //递归到下一行中继续做选择
                backtrack(row + 1, path);
                //撤销选择
                path.remove(row);
                uncheck(row, i);
            }
        }
    }

    //检查选择的点是否会导致同列、同对角线、反对角线出现两个皇后
    private boolean check(int row, int col) {
        if (((columns >> col) & 1) == 1 || ((diagonals >> (row + col)) & 1) == 1 || ((reverseDiag >> (row - col)) & 1) == 1)
            return false;
        //如果没问题就把对应的位置为1，表示选择了该位置
        columns |= (1 << col);
        diagonals |= (1 << (row + col));
        reverseDiag |= (1 << (row - col));
        return true;
    }

    //撤销选择，将对应位置置为0
    private void uncheck(int row, int col) {
        columns &= ~(1 << col);
        diagonals &= ~(1 << (row + col));
        reverseDiag &= ~(1 << (row - col));
    }
}