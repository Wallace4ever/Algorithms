package edu.LeetCode.Array;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明: 
 * * 如果题目有解，该答案即为唯一答案。
 * * 输入数组均为非空数组，且长度相同。
 * * 输入数组中的元素均为非负数。
 */
public class No134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost=0,startIndex=0,startToCurrentCost=0;
        for(int i=0;i<gas.length;i++){
            //tmpCost表示从当前加油站到达下一个加油站至少需要汽车已有油多少升
            int tmpCost=cost[i]-gas[i];
            totalCost+=tmpCost;
            startToCurrentCost+=tmpCost;

            //如果该值大于零，则重置始发站为下一站点，重置startToCurrentCost为0
            if (startToCurrentCost > 0) {
                startIndex = i + 1;
                startToCurrentCost = 0;
            }
        }
        if(totalCost<=0)
            return startIndex;
        else
            return -1;
    }
}
