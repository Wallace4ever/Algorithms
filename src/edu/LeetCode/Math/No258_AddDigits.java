package edu.LeetCode.Math;

public class No258_AddDigits {
    public int addDigits(int num) {
        if (num / 10 == 0) return num;
        int n=0;
        while (num!= 0) {
            n+=num%10;
            num/=10;
        }
        return addDigits(n);
    }

    public int addDigits2(int num) {
        while (num >= 10) {
            int n = 0;
            while (num != 0) {
                n+= num % 10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }
}
