package edu.LeetCode.Math;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class No7_ReverseInteger {
    public static int reverse(int x) {
        int reversed=0;
        while (x != 0) {
            if (reversed>Integer.MAX_VALUE/10||(reversed==Integer.MAX_VALUE/10&&x%10>Integer.MAX_VALUE%10)||
                reversed<Integer.MIN_VALUE/10||(reversed==Integer.MIN_VALUE/10&&x%10<Integer.MIN_VALUE%10)
            )
                return 0;
            reversed=reversed*10+x%10;
            x/=10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("1.01".compareTo("1.001"));
    }
}
