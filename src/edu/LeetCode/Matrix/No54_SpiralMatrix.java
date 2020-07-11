package edu.LeetCode.Matrix;

import java.util.ArrayList;
import java.util.List;

public class No54_SpiralMatrix {
    public List<Integer> spiralOrder(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) return list;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length-1;
        while(true){
            for(int col=left;col<=right;col++){
                list.add(matrix[up][col]);
            }
            // 向下逼近
            if (++up > down) break;

            for(int row=up;row<=down;row++){
                list.add(matrix[row][right]);
            }
            // 向左逼近
            if (--right < left) break;

            for(int col=right;col>=left;col--){
                list.add(matrix[down][col]);
            }
            // 向上逼近
            if (--down < up) break;

            for(int row=down;row>=up;row--){
                list.add(matrix[row][left]);
            }
            // 向右逼近
            if (++left > right) break;
        }
        return list;
    }
}
