package edu.LeetCode.BinarySearch;

import org.junit.Test;

import java.util.Arrays;

public class No354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length, index = 0;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        x:
        for (int i = 1; i < n; i++) {
            int curr = envelopes[i][1];
            if (curr > dp[index]) {
                dp[++index] = curr;
            } else if (curr < dp[index]) {
                //二分查找，将dp数组中首个小于curr值之后的值替换为curr，其实用API更简洁
                //int location = Arrays.binarySearch(dp,0,index+1,curr);
                //if(location < 0) location = -location -1;
                //dp[location] = curr;
                int left = 0, right = index;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] == curr) {
                        continue x;
                    } else if (dp[mid] < curr) {
                        left = mid + 1;
                    } else if (dp[mid] > curr) {
                        right = mid - 1;
                    }
                }
                dp[left] = curr;
            }
        }
        return index + 1;
    }

    @Test
    public void test() {
        System.out.println(maxEnvelopes(new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}}));
        System.out.println(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}
