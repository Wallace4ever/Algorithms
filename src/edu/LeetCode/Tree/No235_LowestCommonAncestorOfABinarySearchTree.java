package edu.LeetCode.Tree;

public class No235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==null||q==null) return null;
        int low=Math.min(p.val,q.val),high=Math.max(p.val,q.val);
        while (!(root.val >= low && root.val <= high)) {
            if (root.val>low)
                root=root.left;
            else
                root=root.right;
        }
        return root;
    }
}
