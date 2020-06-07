package edu.KeyToOffer.Visualization;
import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 注意特殊输入如只有一行、只有一列、只有一行一列
 */
public class CirclePrintMatrix {
    ArrayList<Integer> list;
    boolean[][] isVisited;
    int width,height;

    //思路是，从零开始往右走，遇到边界或者已访问过的则往下走，同理再往左，往上……
    //为了规避特殊情况，被调用者首先检查传入的参数是否合法，是否已访问过，没问题才开始遍历
    //不同于书上的方法，使用了调用而非循环来遍历矩阵中的值
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null||matrix[0]==null) return null;
        height=matrix.length;
        width=matrix[0].length;
        isVisited=new boolean[height][width];
        list=new ArrayList<>();
        goRight(0,0,matrix);
        return list;
    }

    private void goRight(int row, int col,int[][] matrix) {
        if (col>=width||isVisited[row][col]) return;
        list.add(matrix[row][col]);
        isVisited[row][col]=true;
        if (col == width - 1 || isVisited[row][col + 1]) {
            goDown(row + 1, col, matrix);
        } else {
            goRight(row,col+1,matrix);
        }
    }

    private void goDown(int row, int col,int[][] matrix) {
        if (row>=height||isVisited[row][col]) return;
        list.add(matrix[row][col]);
        isVisited[row][col]=true;
        if (row == height - 1 || isVisited[row+1][col]) {
            goLeft(row, col-1, matrix);
        } else {
            goDown(row+1,col,matrix);
        }
    }

    private void goLeft(int row, int col,int[][] matrix) {
        if (col<0||isVisited[row][col]) return;
        list.add(matrix[row][col]);
        isVisited[row][col]=true;
        if (col == 0 || isVisited[row][col-1]) {
            goUp(row-1, col, matrix);
        } else {
            goLeft(row,col-1,matrix);
        }
    }

    private void goUp(int row, int col, int[][] matrix) {
        if (row<0||isVisited[row][col]) return;
        list.add(matrix[row][col]);
        isVisited[row][col]=true;
        if (row == 0 || isVisited[row-1][col]) {
            goRight(row, col+1, matrix);
        } else {
            goUp(row-1,col,matrix);
        }
    }

    public static void main(String[] args) {
        CirclePrintMatrix s=new CirclePrintMatrix();
        int[][] a={{1},{2},{3},{4},{5}};
        s.printMatrix(a);
        System.out.println(s.list);
    }

    //更好的方法使用循环且不需要用到额外O(m*n)的空间
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length == 0||matrix[0].length==0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
