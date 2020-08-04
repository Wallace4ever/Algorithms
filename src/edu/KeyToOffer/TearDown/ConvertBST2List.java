package edu.KeyToOffer.TearDown;

import java.util.ArrayList;
import java.util.List;

public class ConvertBST2List {
    List<TreeNode> list = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        list = new ArrayList<>();
        inorderTraversal(pRootOfTree);
        TreeNode pre = null;
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            if (i == list.size() - 1) curr.right = null;
            curr.left = pre;
            if (pre != null) pre.right = curr;
            pre = curr;
        }
        return list.get(0);
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root);
            inorderTraversal(root.right);
        }
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