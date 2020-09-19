package edu.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class No17_LetterCombinationsOfAPhoneNumber {
    private List<String> result = null;
    private final char[][] maps = new char[][]{{'_'}, {'!', '@', '#'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        for (char map : maps[digits.charAt(index) - '0']) {
            stringBuilder.append(map);
            backtrack(digits, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
