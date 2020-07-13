package edu.LeetCode.DFSBFS;

public class No130_SurroundedRegions {
    private boolean[][] connectedToBorder;
    private final int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    int m,n;

    public void solve(char[][] board) {
        if (board==null||board.length==0) return;;
        m = board.length;
        n = board[0].length;
        connectedToBorder= new boolean[m][n];
        //以边界上的'O'为起点进行DFS
        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O')
                dfs(board, i, 0);
            if (board[i][n-1]=='O')
                dfs(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j]=='O')
                dfs(board, 0, j);
            if (board[m-1][j]=='O')
                dfs(board, m - 1, j);
        }
        //根据结果connectedToBorder来确定是否填充
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O' && !connectedToBorder[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        connectedToBorder[i][j]=true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            //如果之前被标记过了就不用再DFS了
            if (0 <= x && x < m && 0 <= y && y < n && !connectedToBorder[x][y] && board[x][y] == 'O') {
                dfs(board, x, y);
            }
        }
    }
}
