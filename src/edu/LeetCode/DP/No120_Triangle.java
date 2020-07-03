package edu.LeetCode.DP;

import java.util.List;

public class No120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null||triangle.size()==0) return 0;
        int n=triangle.size();

        int[] total=new int[n];
        for (int j = 0; j < n; j++) {
            total[j]=triangle.get(n-1).get(j);
        }
        for (int i = n-2; i >=0 ;i--) {
            for (int j = 0; j < i+1; j++) {
                //当前行为i，得到i+1行对应相邻节点的最小值
                int min=Math.min(total[j],total[j+1]);
                total[j]=min+triangle.get(i).get(j);
            }
        }
        return total[0];
    }
}
