package edu.LeetCode.Array;

public class No189_RotateArray {
    //两次翻转数组法
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%nums.length-1);
        reverse(nums,k%nums.length,nums.length-1);
    }

    private void reverse(int[] nums,int left,int right){
        for(;left<right;left++,right--){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
    }

    //暴力法
    public void rotate1(int[] nums, int k) {
        if(nums==null||nums.length==0) return;
        for(int i=0;i<k%nums.length;i++){
            int tail=nums[nums.length-1];
            for(int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=tail;
        }
    }

    //新数组存储结果
    public void rotate2(int[] nums, int k) {
        if(nums==null||nums.length==0) return;
        int n=nums.length;
        int m=k%n;
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            if(i<=n-1-m){
                temp[i+m]=nums[i];
            }else{
                temp[i-(n-m)]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }
    }
}
