package edu.KeyToOffer.Robust;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubTree {
    /**
     * 遍历root1所在的树，遇到与root2值相同的节点则判断从该节点开始的子树结构是否与root2结构相同
     * @param root1 被匹配的树的根节点
     * @param root2 要匹配的目标子树的根节点
     * @return 是否存在匹配的目标子树
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null) return false;//root2为空直接返回false，root1为空说明已经遍历完树的一个叶子节点也返回false
        boolean b=false;
        if (root1.val== root2.val)//发现节点值相同时调用isSubTree验证是否有相同结构
            b=isSubTree(root1,root2);
        if (b) return b;//仅当相同时才返回true，否则继续递归遍历返回结果
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    /**
     * @param root1 被匹配的节点
     * @param root2 目标节点
     * @return 比较两个节点及其子树是否值相同
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if ( root2 == null) {//当roo2为空时表明该节点的父节点（子树的叶子节点）已经匹配完毕
            return true;
        } else if (root1 != null ) {//root1,root2都不为空时，比较他们的值并递归比较他们的左右节点
            return root1.val==root2.val&&isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        } else {//root2不为空而root1为空说明不匹配
            return false;
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