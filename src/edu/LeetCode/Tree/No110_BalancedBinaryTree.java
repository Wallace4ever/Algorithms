package edu.LeetCode.Tree;

public class No110_BalancedBinaryTree {
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        traversal(root);
        return isBalanced;
    }

    private int traversal(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int leftHeight=traversal(root.left);
        int rightHeight=traversal(root.right);
        if (Math.abs(leftHeight-rightHeight)>1)
            isBalanced=false;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
