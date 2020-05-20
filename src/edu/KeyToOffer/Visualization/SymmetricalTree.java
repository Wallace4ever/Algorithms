package edu.KeyToOffer.Visualization;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }

    /**
     * 对两个节点进行镜像的前序遍历，比较这两个节点本身就是前序，如果为空则停止递归并根据是否都为空返回结果
     * 在都不为空且值相等的基础上，在递归比较pRoot1的左孩子和pRoot2的右孩子，以及pRoot1的右孩子和pRoot2的左孩子，都相同则返回true
     */
    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2) {
        if (pRoot1==null && pRoot2==null) return true;
        if (pRoot1==null || pRoot2==null) return false;
        if (pRoot1.val == pRoot2.val) {
            return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
        } else {
            return false;
        }
    }
}