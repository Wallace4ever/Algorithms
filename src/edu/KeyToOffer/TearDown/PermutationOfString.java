package edu.KeyToOffer.TearDown;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationOfString {
    ArrayList<String> result = null;
    char[] s = null;
    boolean[] visited = null;

    public ArrayList<String> Permutation(String str) {
        result = new ArrayList<>();
        if (str==null||str.length()==0) return result;
        s = str.toCharArray();
        Arrays.sort(s);
        visited = new boolean[s.length];
        backtrack(new StringBuilder());
        return result;
    }

    private void backtrack(StringBuilder path) {
        if (path.length() == s.length) {
            String fullPath = path.toString();
            if (!result.contains(fullPath))
                result.add(fullPath);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(s[i]);
                backtrack(path);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }
}
