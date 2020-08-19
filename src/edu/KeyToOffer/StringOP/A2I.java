package edu.KeyToOffer.StringOP;

import org.junit.Test;

import java.util.HashMap;

public class A2I {
    private final String START="START",MARK="MARK",DIGIT="DIGIT",END="END";
    public int StrToInt(String str) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put(START, new String[]{START, MARK, DIGIT, END});
        map.put(MARK, new String[]{END, END, DIGIT, END});
        map.put(DIGIT, new String[]{END, END, DIGIT, END});
        map.put(END, new String[]{END, END, END, END});

        String state = START;
        int result = 0, mark = 1;
        for (char c : str.toCharArray()) {
            state = map.get(state)[transState(c)];
            if (state.equals(END)) {
                result = 0;
                break;
            }
            if (state.equals(MARK) && c == '-') mark = -1;
            if (state.equals(DIGIT)) {
                int digit=c-'0';
                if (mark==1) {
                    if (result < Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit <= Integer.MAX_VALUE % 10)) {
                        result = result * 10 + digit;
                    } else {
                        result = 0;
                        break;
                    }
                } else if (mark==-1) {
                    if (result > Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -digit >= Integer.MIN_VALUE % 10)) {
                        result = result * 10 - digit;
                    } else {
                        result = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private int transState(char c) {
        if (Character.isDigit(c)) return 2;
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            default:
                return 3;
        }
    }
}