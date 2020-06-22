package edu.LeetCode.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class No179_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs,new numComparator());
        if(strs[0].equals("0")) return "0";
        StringBuilder sb=new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private class numComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2+o1).compareTo(o1+o2);
        }
    }

    public static void main(String[] args) {
        System.out.println("910".compareTo("109"));
    }
}
