package edu.LeetCode.Math;

/**
 * 给出正整数区间[a,b]，找出区间中每一个字面不含 3 5 8 的数字的总数
 */
public class ByteDanceInterview3 {
    //备查表，table[i]表示0到1*power(10,i)范围内包含数字 3 5 8 的整数个数
    private static int[] table;

    public static void main(String[] args) {
        System.out.println(count(0,33));
        System.out.println(count(0,76954));
        System.out.println(count(76952,76954));
    }

    //调用的方法接口，找到(a,b)开区间内包含数字 3 5 8 的整数个数
    public static int count(int a ,int b){
        int temp=b,bit=0;
        while(temp!=0){
            temp/=10;
            bit++;
        }
        table=bit>2?new int[bit+1]:new int[3];
        table[0]=0;
        table[1]=1;
        table[2]=3;
        table=prepare(bit,table);
        //得到的是[0,b]闭区间减去[0,a]闭区间内包含目标数的数量
        return getContainCount(b)-getContainCount(a);
    }

    //得出0到当前数字中包含3 5 8 的数字的个数
    private static int getContainCount(int a){
        int countA=0,bitOfA=1;
        while(a!=0){
            int curr=a%10;
            int sum=0;
            if(curr>=8){
                sum=3*(int)Math.pow(10,bitOfA-1)+(curr-3)*table[bitOfA-1];
            }else if(curr>=5){
                sum=2*(int)Math.pow(10,bitOfA-1)+(curr-2)*table[bitOfA-1];
            }else if(curr>=3){
                sum=(int)Math.pow(10,bitOfA-1)+(curr-1)*table[bitOfA-1];
            }else{
                sum=curr*table[bitOfA-1];
            }
            countA+=sum;
            bitOfA++;
            a/=10;
        }
        return countA;
    }

    //准备表
    private static int[] prepare(int height,int[] table){
        if(height>=3){
            table=prepare(height-1,table);
            table[height]=3*(int)Math.pow(10,height-2)+7*table[height-1];
        }
        return table;
    }
}
