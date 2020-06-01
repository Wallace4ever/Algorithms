package edu.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class No1431_KidsWithMostCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies==null||candies.length<1||extraCandies<0) return null;
        List<Boolean> list=new ArrayList<>();
        int maxCandies=0;
        for (int candie : candies) {
            if (candie>maxCandies)
                maxCandies=candie;
        }
        for (int candie : candies) {
            list.add((candie + extraCandies) >= maxCandies);
        }
        return list;
    }
}
