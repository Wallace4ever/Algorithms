package edu.LeetCode.Tree;

public class No98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if(isValidBST(root.left)&&isValidBST(root.right)&&root.val>getMax(root.left)&&root.val<getMin(root.right)) return true;
        return false;
    }

    private long getMin(TreeNode root) {
        if (root==null) return Long.MAX_VALUE;
        while (root.left != null) {
            root=root.left;
        }
        return root.val;
    }
    private long getMax(TreeNode root) {
        if (root==null) return Long.MIN_VALUE;
        while (root.right != null) {
            root=root.right;
        }
        return root.val;
    }
}

class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Object[] result=traversal(root);
        return (Boolean) result[0];
    }

    private Object[] traversal(TreeNode root) {
        //第二个数存贮树的最小值，第三个存最大值
        Object[] info=new Object[3];
        if (root == null) {
            info[0]=true;
            info[1]=Long.MAX_VALUE;
            info[2]=Long.MIN_VALUE;
            return info;
        }
        Object[] leftInfo=traversal(root.left);
        Object[] rightInfo=traversal(root.right);
        boolean b = (Boolean) leftInfo[0] && (Boolean) rightInfo[0] &&root.val>(Long)leftInfo[2]&&root.val<(Long)rightInfo[1];
        info[0]=b;
        info[1]=(Long) leftInfo[1]==Long.MAX_VALUE?root.val:(Long) leftInfo[1];
        info[2]=(Long) rightInfo[2]==Long.MIN_VALUE?root.val:(Long) rightInfo[2];
        return info;
    }
}