package edu.KeyToOffer.TimeSpaceBalance;

public class No49_UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        int[] ugly = new int[index];
        //初始化第一个丑数
        ugly[0] = 1;
        //指向乘以2、3、5后可能会大于当前最大丑数的位置
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            ugly[i] = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (ugly[i] == ugly[p2] * 2) p2++;
            if (ugly[i] == ugly[p3] * 3) p3++;
            if (ugly[i] == ugly[p5] * 5) p5++;
        }
        return ugly[index - 1];
    }
}
