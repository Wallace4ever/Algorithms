package edu.LeetCode.BackTracking;

import java.util.*;

public class No77_Combinations {
    List<List<Integer>> result;
    boolean[] used;
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        result=new ArrayList<>();
        if (n<=0||k<=0) return result;
        this.n=n;
        this.k=k;
        used=new boolean[n+1];
        dfs(1,new ArrayDeque<>());
        return result;
    }

    private void dfs(int start,Deque<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=n; i++) {
            if (!used[i]) {
                path.offerLast(i);
                used[i]=true;
                dfs(i+1,path);
                path.pollLast();
                used[i]=false;
            }
        }
    }
}
