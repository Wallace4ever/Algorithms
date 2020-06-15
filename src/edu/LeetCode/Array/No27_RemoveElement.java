package edu.LeetCode.Array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class No27_RemoveElement {
    //细节处理有问题的解法，两个指针分别从左右移动
    public int removeElement0(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        int left=0,right=nums.length-1;
        while (left <= right) {
            //当左指针发现值等于目标值时
            if (nums[left] == val) {
                //让右指针指向当前从右往左的第一个不等于val的数（如果数组全等于目标值会异常）
                while (nums[right] == val) {
                    right--;
                }
                //拷贝该数到左指针处并将右指针减一
                nums[left]=nums[right];
                right--;
            }
            //无论是否发生了拷贝左指针都加1是有问题的，例如[3,2,3] 3
            left++;
        }
        return left;
    }

    //正确的双指针从左右两侧移动的方法
    public int removeElement(int[] nums, int val) {
        if (nums==null) return 0;
        int i = 0;
        int n = nums.length;//右指针应应理解为新数组的长度，规避数组长度为0的情况
        while (i < n) {
            if (nums[i] == val) {
                //不用检查右指针指向数字是否可能是目标数字，因为在下次循环中还会再作检查
                nums[i] = nums[n - 1];
                //已经知道有一个目标数，则新数组长度减一
                n--;
            } else {
                //nums[i]没问题才会向右移动左指针
                i++;
            }
        }
        return n;
    }

    //此外还可以让双指针都从左侧出发，快指针每次只寻找非目标数的数，依次将快指针指向的内容复制到慢指针处，慢指针每次复制后+1。
    public int removeElement1(int[] nums, int val) {
        if (nums==null) return 0;
        int slow=0,fast=0;
        //可用for精简表达
        while(fast<nums.length){
            if(nums[fast]==val){
                fast++;
            }else{
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
