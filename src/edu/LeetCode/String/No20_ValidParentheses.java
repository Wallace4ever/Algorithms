package edu.LeetCode.String;

import java.util.ArrayDeque;
import java.util.Deque;

public class No20_ValidParentheses {
    public boolean isValid(String s) {
        if (s==null||s.length()==0) return true;
        Deque<Character> stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty()||stack.pop()!=s.charAt(i))
                        return false;
            }
        }
        return stack.isEmpty();
    }
}
