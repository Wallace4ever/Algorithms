package edu.LeetCode.Matrix;

public class No378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //如果小于等于mid的数的数目count>=k，则第k小的数的大小不可能超过mid（有可能等于mid）
            if (getCount(matrix,mid,n)>=k) {
                right = mid;
            } else {//否则第k小的数一定大于mid
                left = mid + 1;
            }
        }
        return left;
    }

    private int getCount(int[][] matrix, int mid, int n) {
        int i = n - 1, j = 0, count = 0;
        while (i >= 0 && j <= n - 1) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
