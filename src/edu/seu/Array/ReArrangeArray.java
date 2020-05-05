package edu.seu.Array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReArrangeArray {
    public void reOrderArray(int [] array) {
        int[] arr=new int[array.length];
        int index=0;
        for (int value : array) {
            if (value % 2 == 1) {
                arr[index] = value;
                index++;
            }
        }
        for (int value : array) {
            if (value % 2 == 0) {
                arr[index] = value;
                index++;
            }
        }
        System.arraycopy(arr,0,array,0,array.length);
    }
}