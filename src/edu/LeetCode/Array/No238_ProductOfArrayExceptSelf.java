package edu.LeetCode.Array;

public class No238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        int k=1;
        for (int i = 0; i < nums.length; i++) {
            result[i]=k;//k临时存储当前前缀积并存在result[i]中
            k*=nums[i];
        }
        k=1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i]*=k;//这里是已有的前缀积乘以当前后缀积k
            k*=nums[i];
        }
        return result;
    }
}
