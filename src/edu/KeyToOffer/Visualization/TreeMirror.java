package edu.KeyToOffer.Visualization;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 题目本质是利用树的遍历解决问题，镜像这一抽象概念课以通过画出几个例子来解构
 */
public class TreeMirror {
    /**
     * 对于树的节点，若该节点不为空或该节点不为叶子节点，则交换其左右孩子，并对其左右孩子递归调用该方法
     */
    public void Mirror(TreeNode root) {
        if (root==null) return;
        if (root.left==null&&root.right==null) return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}