package edu.LeetCode.Array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class No80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int slow=0,fast,times=1;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]==nums[slow]){
                switch(times){
                    case 1:
                        times++;
                        break;
                    case 2:
                        times++;
                        nums[++slow]=nums[fast];
                        break;
                }
            }else{
                nums[++slow]=nums[fast];
                times=2;
            }
        }
        return slow+1;
    }

    //上面的方法是基于比较相邻数字，统计相同数字的出现次数的；
    // 而该方法是比较生成的数组倒数第二位和右指针，并不关心某一数字的具体出现次数。
    public int removeDuplicates1(int[] nums) {
        if(nums==null) return 0;
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
