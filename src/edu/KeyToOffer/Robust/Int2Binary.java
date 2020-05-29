package edu.KeyToOffer.Robust;

public class Int2Binary {
    //打印出整数的二进制表示
    public static void main(String[] args) {
        int a=43545;
        int t = 0;
        for (int i = 31; i>=0; i--) {
            t = a&(1<<i);
            //无符号右移时负数最高位补0
            t = t>>>i;
            System.out.print(t);
        }
    }
}
