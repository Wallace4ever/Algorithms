package edu.KeyToOffer.OptimizeTime;

public class NumbersOverHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0) return 0;
        int count = 1, maxAppear = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == maxAppear) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                count=1;
                maxAppear = array[i];
            }
        }
        count = 0;
        for (int num : array) {
            if (num==maxAppear) count++;
        }
        return count > array.length / 2 ? maxAppear : 0;
    }
}
