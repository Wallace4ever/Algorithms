package edu.LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class No257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(root,list,"");
        return list;
    }

    private void binaryTreePaths(TreeNode current, List<String> list, String string) {
        if (current != null) {
            String s=string+current.val;
            if (current.left == null && current.right == null) {
                list.add(s);
            } else {
                binaryTreePaths(current.left,list,s+"->");
                binaryTreePaths(current.right,list,s+"->");
            }
        }
    }
}

