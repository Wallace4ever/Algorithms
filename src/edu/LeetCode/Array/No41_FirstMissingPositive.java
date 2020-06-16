package edu.LeetCode.Array;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 */
public class No41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        //for循环结束时保证整个数组中在答案取值范围内的数x都在x-1位置
        for (int i = 0; i < n; i++) {
            //while循环结束时能保证当前的nums[i]要么在答案取值范围外，要么和下标吻合哈希性质(即nums[i]==i+1)
            //nums[i] != nums[nums[i] - 1]是为了避免重复数字造成的死循环例如[-1,3,3,4]
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                //当前的nums[i]在答案的取值范围内不等于i-1时，把nums[i]和nums[nums[i]-1]交换
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
