package edu.KeyToOffer.Visualization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindTargetPathInTree {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> initialPath = new ArrayList<>();
        initialPath.add(root.val);
        queue.offer(new Pair(root, initialPath, root.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair pair = queue.poll();
                TreeNode left = pair.node.left, right = pair.node.right;
                if (left == null && right == null && pair.totalLength == target) {
                    result.add(pair.path);
                }else {
                    if (left != null){
                        ArrayList<Integer> nextPath = new ArrayList<>(pair.path);
                        nextPath.add(left.val);
                        queue.offer(new Pair(left, nextPath, pair.totalLength + left.val));
                    }
                    if (right != null) {
                        ArrayList<Integer> nextPath = new ArrayList<>(pair.path);
                        nextPath.add(right.val);
                        queue.offer(new Pair(right, nextPath, pair.totalLength + right.val));
                    }

                }
            }
        }
        return result;
    }

    private class Pair{
        TreeNode node;
        ArrayList<Integer> path;
        int totalLength;

        public Pair(TreeNode node, ArrayList<Integer> path, int totalLength) {
            this.node = node;
            this.path = path;
            this.totalLength = totalLength;
        }
    }
}

class FindTargetPathInTree2{
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    int target = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return result;
        this.target = target;
        dfs(root,new ArrayList<>(),0);
        return result;
    }

    private void dfs(TreeNode node, ArrayList<Integer> path, int pathLength) {
        ArrayList<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(node.val);
        if (node.left == null && node.right == null ) {
            if (pathLength + node.val == target) {
                result.add(currentPath);
            }
            return;
        }
        if (node.left == null) {
            dfs(node.right, currentPath, pathLength + node.val);
            return;
        }
        if (node.right == null) {
            dfs(node.left, currentPath, pathLength + node.val);
            return;
        }
        if (node.left.val < node.right.val) {
            dfs(node.left, currentPath, pathLength + node.val);
            dfs(node.right, currentPath, pathLength + node.val);
        } else {
            dfs(node.right, currentPath, pathLength + node.val);
            dfs(node.left, currentPath, pathLength + node.val);
        }
    }
}
