package edu.KeyToOffer.AbstractModel;

public class No62_LastRemainingInCircle {
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
