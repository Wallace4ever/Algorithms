package edu.KeyToOffer.KnowledgeMigration;

public class No54_KthNodeOfBST {
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) return null;
        TreeNode answer = null;
        if (pRoot.left != null) answer = KthNode(pRoot.left, k);
        if (answer != null) return answer;
        if (++count == k) return pRoot;
        if (pRoot.right != null) answer = KthNode(pRoot.right, k);
        return answer;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}