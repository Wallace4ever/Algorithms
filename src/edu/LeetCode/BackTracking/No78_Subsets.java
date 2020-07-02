package edu.LeetCode.BackTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No78_Subsets {
    List<List<Integer>> results=new ArrayList<>();
    int k=0;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        for (; k <= nums.length; k++) {
            backtrack(nums,0,new ArrayList<>());
        }
        return results;
    }

    private void backtrack(int[] nums, int start,ArrayList<Integer> path) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

class SubSet {
    List<List<Integer>> result;
    int[] nums;
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if (nums==null) return result;
        this.nums=nums;
        n=nums.length;
        dfs(0,new ArrayList<>());
        return result;
    }

    private void dfs(int start,List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < n; i++) {
            path.add(nums[i]);
            dfs(i+1,path);
            path.remove(path.size()-1);
        }
    }
}
