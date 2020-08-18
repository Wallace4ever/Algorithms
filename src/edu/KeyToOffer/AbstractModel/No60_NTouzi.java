package edu.KeyToOffer.AbstractModel;

import java.util.Arrays;

public class No60_NTouzi {
    public double[] twoSum(int n) {
        double[][] result = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            result[1][i] = 1 / 6.0;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6 && k < j; k++) {
                    result[i][j] += result[1][k] * result[i - 1][j - k];
                }
            }
        }
        return Arrays.copyOfRange(result[n], n, 6 * n + 1);
    }
}
