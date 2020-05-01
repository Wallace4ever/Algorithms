package edu.seu.DPandRecursion;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 在你面前有一个n阶的楼梯(n>=100且n<500)，你一步只能上1阶或3阶。
 * 请问计算出你可以采用多少种不同的方式爬完这个楼梯（到最后一层为爬完）。
 * (注意超大数据)
 */
public class StageJump2 {
    /**
     *数据超大时可以用java.math.BigInteger/BigDecimal来处理，注意和java.lang.Math不同
     */
        public static void main(String args[]){
            Scanner s= new Scanner(System.in);
            int n=s.nextInt();
            BigInteger[] res= new BigInteger[n + 1];
            res[1]= BigInteger.valueOf(1);
            res[2]= BigInteger.valueOf(1);
            res[3]= BigInteger.valueOf(2);
            for(int i=4;i<=n;i++){
                res[i]=res[i-1].add(res[i-3]);
            }
            System.out.println(res[n]);
        }
}
