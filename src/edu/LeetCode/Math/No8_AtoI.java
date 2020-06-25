package edu.LeetCode.Math;

import java.util.HashMap;
import java.util.Map;

public class No8_AtoI {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

    public int myAtoi2(String str) {
        Automaton automaton=new Automaton();
        char[] c=str.toCharArray();
        for (char ch : c) {
            automaton.run(ch);
        }
        return automaton.sign * (int)automaton.ans;
    }

    private class Automaton {
        final String START="start";
        final String SIGNED="singed";
        final String IN_NUM="in_number";
        final String END="end";

        String state=START;
        Map<String,String[]> map;
        int sign=1;
        long ans=0;

        public Automaton() {
            map=new HashMap<>();
            map.put(START,new String[]{START,SIGNED,IN_NUM,END});
            map.put(SIGNED,new String[]{END,END,IN_NUM,END});
            map.put(IN_NUM,new String[]{END,END,IN_NUM,END});
            map.put(END,new String[]{END,END,END,END});
        }

        public int chooseColumn(char c) {
            if (c==' ') return 0;
            if (c=='+'||c=='-') return 1;
            if (Character.isDigit(c)) return 2;
            return 3;
        }

        public void run(char c) {
            if (state.equals(END)) return;
            //这里就实现了自动机状态的转换
            state=map.get(state)[chooseColumn(c)];
            switch (state) {
                case SIGNED:
                    sign=(c=='+')?1:-1;
                    break;
                case IN_NUM:
                    ans=ans*10+c-'0';
                    if (sign == 1) {
                        ans = Math.min(ans, Integer.MAX_VALUE);
                    } else {
                        ans = -Math.max(-ans, Integer.MIN_VALUE);
                    }
            }
        }
    }

}
