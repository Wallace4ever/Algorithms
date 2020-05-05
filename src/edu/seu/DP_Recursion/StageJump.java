package edu.seu.DP_Recursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class StageJump {
    public static void main(String[] args) {

    }

    /**
     *递归解法
     */
    public int JumpFloor(int target) {
        switch (target){
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /**
     *动态规划解法，使用数组自底向上存储每一个res[n]
     */
    public int JumpFloor2(int target){
        if (target==2||target==1){
            return target;
        }
        int[] res=new int[target+1];
        res[1]=1;
        res[2]=2;
        for (int i=3;i<=target;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[target];
    }

    /**
     * 小优化
     *由于每次计算只需要前面连续两个数的值所以可以只用两个int来暂存，节省一点空间
     * （牛客提交时占用内存反而多了）
     */
    public int JumpFloor3(int target){
        if (target==2||target==1){
            return target;
        }
        int left=1,mid=2,right=0;
        for (int i=3;i<=target;i++){
            right=left+mid;
            left=mid;
            mid=right;
        }
        return right;
    }
}
