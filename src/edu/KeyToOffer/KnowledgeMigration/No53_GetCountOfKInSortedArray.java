package edu.KeyToOffer.KnowledgeMigration;

public class No53_GetCountOfKInSortedArray {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        if (k < array[0] || k > array[array.length - 1]) return 0;
        int right = findBoundary(array, k, false);
        if (right == -1) return 0;
        return right - findBoundary(array, k, true) + 1;
    }

    private int findBoundary(int[] array, int target, boolean findLeft) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                if (findLeft)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        if (findLeft && left < array.length && array[left] == target)
            return left;
        if (!findLeft && right >= 0 && array[right] == target)
            return right;
        return -1;
    }
}
