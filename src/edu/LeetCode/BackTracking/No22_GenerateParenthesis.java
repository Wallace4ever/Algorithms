package edu.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class No22_GenerateParenthesis {
    private List<String> list;
    private int n;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        this.n = n;
        backtrack(new StringBuilder(), 0, 0);
        return list;
    }

    private void backtrack(StringBuilder path, int leftBrackets, int rightBrackets){
        //递归终止条件
        if(leftBrackets == n && rightBrackets == n){
            list.add(path.toString());
            return;
        }

        //选择1：选择左括号
        if(leftBrackets < n){
            path.append('(');
            backtrack(path, leftBrackets + 1, rightBrackets);
            path.deleteCharAt(path.length() - 1);
        }

        //选择2：选择右括号
        if(rightBrackets < n && leftBrackets > rightBrackets){
            path.append(')');
            backtrack(path, leftBrackets, rightBrackets + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
