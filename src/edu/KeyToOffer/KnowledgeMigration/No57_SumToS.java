package edu.KeyToOffer.KnowledgeMigration;

import java.util.ArrayList;

public class No57_SumToS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) return list;
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
            if (array[left] + array[right] < sum)
                left++;
            if (array[left] + array[right] > sum)
                right--;
        }
        return list;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int left = 1, right = 2, totalVal = 3;
        while (right <= sum / 2 + 1 && left < right) {
            if (totalVal == sum) {
                ArrayList<Integer> result = new ArrayList<>();
                for (int i = left; i <= right; i++)
                    result.add(i);
                results.add(result);
                totalVal += ++right;
            } else if (totalVal < sum) {
                totalVal += ++right;
            } else {
                totalVal -= left++;
            }
        }
        return results;
    }
}
