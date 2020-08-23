package edu.LeetCode.Math;

import java.util.Arrays;

public class No204_CountPrimes {
    public int countPrimes0(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime[i] ? 1 : 0;
        }
        return count;
    }

    public int countPrimes(int n) {
        if (n < 3) return 0;
        int count = 1, root = (int) Math.sqrt(n);
        boolean[] isPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            if (!isPrime[i]) {
                if (i <= root) {
                    for (int j = i; j * i < n; j += 2)
                        isPrime[i*j]=true;
                }
                count++;
            }
        }
        return count;
    }
}
