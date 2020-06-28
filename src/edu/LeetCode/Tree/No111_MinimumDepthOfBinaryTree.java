package edu.LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class No111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int depth=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            while (size > 0) {
                TreeNode current=queue.poll();
                if (current.left == null && current.right == null) {
                    return depth;
                } else {
                    if (current.left!=null)
                        queue.offer(current.left);
                    if (current.right!=null)
                        queue.offer(current.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
