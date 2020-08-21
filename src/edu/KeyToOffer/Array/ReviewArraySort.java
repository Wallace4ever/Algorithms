package edu.KeyToOffer.Array;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ReviewArraySort {
    @Test
    public  void test() {
        int[] arr = new int[]{14, 52, 26, 3, 67, 9, 86, 48, 10, 70, 1};
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //冒泡排序
    public void bubbleSort(int[] array){
        while(true){
            boolean swapped = false;
            for(int i = 1; i < array.length; i++){
                if(array[i - 1] > array[i]){
                    swapped = true;
                    swap(array, i-1, i);
                }
            }
            if(!swapped)
                break;
        }
    }

    //选择排序
    public void selectSort(int[] array){
        int start = 0;
        while(start < array.length - 1){
            int minIndex = start, min = array[start];
            for(int i = start + 1;i < array.length; i++){
                if(array[i] < min){
                    min = array[i];
                    minIndex = i;
                }
            }
            swap(array, start, minIndex);
            start++;
        }
    }

    //插入排序
    public void insertSort(int[] array){
        for(int i = 1;i < array.length; i++){
            for(int j = i; j > 0 && array[j] < array[j-1]; j--){
                swap(array, j, j-1);
            }
        }
    }

    //归并排序
    public void mergeSort(int[] array){
        mSort(array,0, array.length - 1);
    }

    private void mSort(int[] array, int left, int right){
        if(left == right) return;
        int mid = left + ((right - left) >> 1);
        mSort(array, left, mid);
        mSort(array, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int leftPointer = left, rightPointer = mid + 1, index = 0;
        while(leftPointer <= mid && rightPointer <= right){
            if(array[leftPointer] > array[rightPointer])
                temp[index++] = array[rightPointer++];
            else
                temp[index++] = array[leftPointer++];
        }
        while(leftPointer <= mid)
            temp[index++] = array[leftPointer++];
        while(rightPointer <= right)
            temp[index++] = array[rightPointer++];
        System.arraycopy(temp, 0, array, left, right - left + 1);
    }

    //快速排序
    public void quickSort(int[] array){
        qSort(array, 0, array.length - 1);
    }

    private void qSort(int[] array, int left, int right){
        if(left >= right) return;
        int pivot = array[right], firstLargerIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivot)
                swap(array, i, firstLargerIndex++);
        }
        swap(array, firstLargerIndex, right);
        qSort(array, left, firstLargerIndex - 1);
        qSort(array, firstLargerIndex + 1, right);
    }

    //二分插入排序
    public void binarySort(int[] array){
        for(int i = 1; i < array.length; i++){
            int left = 0, right = i - 1;
            int pivot = array[i];
            if(pivot > array[right]) continue;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                if(array[mid] > pivot)
                    right = mid - 1;
                else if(array[mid] <= pivot)
                    left = mid + 1;
            }
            //这里JDK还根据i-left的长度作了优化，长度为1和2时不调用该函数直接交换值
            System.arraycopy(array, left, array, left + 1, i - left);
            array[left] = pivot;
        }
    }

    //希尔排序
    public void shellSort(int[] array){
        int n = array.length;
        for(int gap = n / 2; gap > 0; gap /= 2){
            for(int i = gap; i < n; i++){
                for(int j = i; j - gap >= 0 && array[j - gap] > array[j]; j -= gap){
                    swap(array, j - gap, j);
                }
            }
        }
    }

    //计数排序
    public void countSort(int[] array){
        //找区间边界
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : array){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        //计数
        int k = max - min;
        int[] count = new int[k + 1];
        for(int num : array){
            count[num - min]++;
        }

        //反向填充
        int index = 0;
        for(int i = 0; i < k + 1; i++){
            while(count[i]-- > 0)
                array[index++] = i + min;
        }
    }

    //基数排序
    public void radixSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array)
            max = Math.max(max, num);

        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayDeque<>();
        }

        int divider = 1;
        //一共有max的位数轮
        while (max != 0) {
            max /= 10;
            for (int num : array) {
                buckets[(num / divider) % 10].offer(num);
            }

            //反向填充
            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    array[index++] = bucket.poll();
                }
            }
            divider *= 10;
        }
    }
}
