package edu.LeetCode.String;

public class No6_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s == null || s.length() <= 2) return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows ; i++)
            builders[i] = new StringBuilder();

        int direction = -1, row = 0;
        for (int index = 0; index < s.length(); index++) {
            builders[row].append(s.charAt(index));
            if (row == 0 || row == numRows - 1) direction = -direction;
            row += direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : builders)
            result.append(sb);
        return result.toString();
    }
}
