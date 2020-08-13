package edu.KeyToOffer.TimeSpaceBalance;

import org.junit.Test;

public class No51_InversePairs {
    int pairs = 0;
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) return pairs;
        int n = array.length;
        int[] copy = new int[n];
        mergeSort(array, copy, 0, n - 1);
        return pairs;
    }

    private void mergeSort(int[] array,int[] copy,int left,int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(array, copy, left, mid);
        mergeSort(array, copy, mid + 1, right);
        merge(array, copy, left, mid, right);
    }

    private void merge(int[] array, int[] copy, int left, int mid, int right) {
        int leftPointer = mid, rightPointer = right, copyIndex = right;
        while (leftPointer >= left && rightPointer >= mid + 1) {
            if (array[leftPointer] > array[rightPointer]) {
                pairs += (rightPointer - mid);
                copy[copyIndex--] = array[leftPointer--];
            } else {
                copy[copyIndex--] = array[rightPointer--];
            }
        }
        while (leftPointer >= left) {
            copy[copyIndex--] = array[leftPointer--];
        }
        while (rightPointer >= mid + 1) {
            copy[copyIndex--] = array[rightPointer--];
        }
        System.arraycopy(copy, left, array, left, right - left + 1);
    }

    @Test
    public void test() {
        System.out.println(InversePairs(new int[]{7,5,6,4}));
    }
}
