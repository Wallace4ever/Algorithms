package edu.LeetCode.Stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No71_SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs=path.split("/");
        for (String dir : dirs) {
            if (dir.length() != 0&&!dir.equals(".")) {
                if (dir.equals("..")) {
                    stack.poll();
                } else {
                    stack.push(dir);
                }
            }
        }
        StringBuilder sb=new StringBuilder("/");
        if (!stack.isEmpty()) {
            while (stack.size()>1) {
                sb.append(stack.pollLast()).append("/");
            }
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s=new String("qwe"),t=new String("qwe");
        System.out.println(s==t);
    }
}
