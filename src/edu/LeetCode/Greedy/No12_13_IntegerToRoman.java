package edu.LeetCode.Greedy;

import org.junit.Test;

import java.util.Arrays;

public class No12_13_IntegerToRoman {
    public String intToRoman(int num) {
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0, result = 0;
        for (int i = 0; i < strings.length; i++) {
            while (index < s.length() && s.substring(index, index + 1).equals(strings[i])) {
                result += values[i];
                index++;
            }
            while (index < s.length() - 1 && s.substring(index, index + 2).equals(strings[i])) {
                result += values[i];
                index += 2;
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        int right = 0, result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));
            result += value >= right ? value : -value;
            right = value;
        }
        return result;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    @Test
    public void test() {
        System.out.println(romanToInt2("MCMXCIV"));
    }
}
