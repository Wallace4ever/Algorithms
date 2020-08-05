package edu.KeyToOffer.OptimizeTime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LeastKNums {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) return list;
        int left = 0, right = input.length;
        while (left < right) {
            int pivot = partition(input, left, right);
            if (pivot == k-1) {
                for (int i = 0; i <= pivot; i++) {
                    list.add(input[i]);
                }
                return list;
            }
            if (pivot < k-1) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return list;
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right - 1];
        int index = left;
        for (int i = left; i < right - 1; i++) {
            if (array[i] < pivot) {
                swap(array,index,i);
                index++;
            }
        }
        swap(array, index, right - 1);
        return index;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(int[] array,int left,int right) {
        if (left>=right-1) return;
        int pivot = partition(array, left, right);
        sort(array, left, pivot);
        sort(array, pivot + 1, right);
    }

    @Test
    public void test() {
        //GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},8).forEach(System.out::println);
        int[] a=new int[]{4,5,1,6,2,7,3,8,4,4};
        sort(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }
}
