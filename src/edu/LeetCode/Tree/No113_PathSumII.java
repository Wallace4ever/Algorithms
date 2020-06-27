package edu.LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;

public class No113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultSet=new LinkedList<>();
        if (root != null) {
            List<Integer> currentPath= new LinkedList<>();
            traversal(resultSet,currentPath,root,sum);
        }
        return resultSet;
    }

    private void traversal(List<List<Integer>> resultSet,List<Integer> currentPath,TreeNode current,int sum){
        if (current != null) {
            List<Integer> path = new LinkedList<>(currentPath);
            path.add(current.val);
            if (current.left == null && current.right == null && current.val == sum) {
                resultSet.add(path);
            } else {
                traversal(resultSet,path,current.left,sum-current.val);
                traversal(resultSet,path,current.right,sum-current.val);
            }
        }
    }
}
