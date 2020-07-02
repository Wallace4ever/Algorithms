package edu.LeetCode.BackTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No46_Permutations {
    List<List<Integer>> result;
    boolean[] used;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        this.nums=nums;
        used=new boolean[nums.length];
        dfs(new ArrayDeque<>());
        return result;
    }

    private void dfs(Deque<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (!used[i]) {
                path.offer(nums[i]);
                used[i]=true;
                dfs(path);
                path.pollLast();
                used[i]=false;
            }
        }
    }
}
