package edu.seu.Tree;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。(就是其中序遍历的第k个结果)
 */
public class KstSmallOfBST {
    ArrayList<TreeNode> list=new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k){
        if (k<=0)
            return null;
        InOrder(pRoot);
        if (k>list.size())
            return null;
        return list.get(k-1);

    }
    void InOrder(TreeNode node){
        if (node==null)
            return;
        InOrder(node.left);
        list.add(node);
        InOrder(node.right);
    }
}
