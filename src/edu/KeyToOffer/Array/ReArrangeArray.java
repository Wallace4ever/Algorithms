package edu.KeyToOffer.Array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReArrangeArray {
    //使用额外O(n)空间
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

    //使用两个指针从两侧扫描并交换
    public void reOrderArray2(int[] array) {
        int left=0,right=array.length-1;
        while (left < right) {
            while ((array[left] & 1) == 1) {
                ++left;
            }
            while ((array[right] & 1) == 0) {
                --right;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            } else {
                break;
            }
        }
    }

    //使用两个指针从左向右扫描，这两种都不能保证奇数间/偶数间相对位置不变
    public void reOrderArray3(int[] array) {
        int left=0,right=0;
        while (right < array.length) {
            while ((array[left] & 1) == 1) {
                ++left;
            }
            right=left+1;
            while ((array[right] & 1) == 0) {
                if (right < array.length-1) {
                    ++right;
                } else {//如果right已抵达数组右侧则说明left及其右侧都是偶数
                    return;
                }
            }
            //停止while循环说明此时的array[right]为奇数
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
}