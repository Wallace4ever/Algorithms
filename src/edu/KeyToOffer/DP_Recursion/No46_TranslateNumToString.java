package edu.KeyToOffer.DP_Recursion;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * (0 <= num < 2^31)
 */
public class No46_TranslateNumToString {
    //转换数字到数组中
    public int translateNum(int num) {
        int length=0;
        int n=num;
        do {
            n/=10;
            length++;
        }while (n!=0);
        int[] array=new int[length];
        for (int i = length - 1; i >= 0; i--) {
            array[i]=num%10;
            num/=10;
        }
        return getResult(array,length);
    }

    //递归解法，也可以不传length而在递归时调用System.arrayCopy()传子数组
    public int getResult(int[] num,int length) {
        switch (length) {
            case 1:
                return 1;
            case 2:
                int value=num[0]*10+num[1];
                return (value > 9 && value < 26) ? 2 : 1;
            default:
                int last2num=num[length-2]*10+num[length-1];
                return (last2num > 9 && last2num < 26)?getResult(num,length-2)+getResult(num,length-1):getResult(num,length-1);
        }
    }

    //转换到数组方法同上
    public int getResult(int[] num) {
        //1位或2位数字时直接返回结果
        switch (num.length) {
            case 1:
                return 1;
            case 2:
                int value = num[0] * 10 + num[1];
                return (value > 9 && value < 26) ? 2 : 1;
        }

        //3位以上时使用dp数组保存结果
        int[] dp=new int[num.length+1];
        dp[1]=1;
        int value = num[0] * 10 + num[1];
        dp[2]= (value > 9 && value < 26) ? 2 : 1;

        for (int i = 3; i < dp.length; i++) {
            int last2num=num[i-2]*10+num[i-1];
            dp[i]=(last2num > 9 && last2num < 26)?dp[i-2]+dp[i-1]:dp[i-1];
        }
        return dp[dp.length-1];
    }
}
