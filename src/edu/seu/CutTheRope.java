package edu.seu;
import java.util.Scanner;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutTheRope {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(findMax2(true,n));
    }

    /**
     * 单纯的递归，自顶向下
     */
    private static int findMax(boolean flag,int i){
        if(flag){
            switch(i){
                case 1:
                    return 1;
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 4;
            }
        }else if(i<=4){
            return i;
        }
        int max=0;
        for(int j=1;j<=i/2;j++){
            int temp=findMax(false,j)*findMax(false,i-j);
            max= Math.max(temp, max);
        }
        return max;
    }

    /**
     *动态规划，自底向上记录每个maxResult[i]
     */
    private static int findMax2(boolean flag,int i){
        switch (i){
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
        }
        int[] maxSet=new int[i+1];
        maxSet[0]=0;
        maxSet[1]=1;
        maxSet[2]=2;
        maxSet[3]=3;
        for (int j=4;j<=i;j++){
            int max=0;
            for (int k=1;k<=j/2;k++){
                int temp=maxSet[k]*maxSet[j-k];
                max=Math.max(max,temp);
            }
            maxSet[j]=max;
        }
        return maxSet[i];
    }
}
