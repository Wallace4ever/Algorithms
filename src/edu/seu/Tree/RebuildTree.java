package edu.seu.Tree;

import java.util.Arrays;

/**
 * 给出一个树的前序遍历和中序遍历结果，还原该二叉树
 */
public class RebuildTree {
    public static void main(String[] args) {
        RebuildTree r=new RebuildTree();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root=r.reConstructBinaryTree(pre,in);
        r.preOrder(root);
        System.out.println();
        r.inOrder(root);
        System.out.println();
        r.postOrder(root);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||in.length==0){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                int[] leftPre= Arrays.copyOfRange(pre,1,i+1);
                int[] leftIn=Arrays.copyOfRange(in,0,i);
                int[] rightPre=Arrays.copyOfRange(pre,i+1,pre.length);
                int[] rightIn=Arrays.copyOfRange(in,i+1,in.length);
                root.left=reConstructBinaryTree(leftPre,leftIn);
                root.right=reConstructBinaryTree(rightPre,rightIn);
                break;
            }
        }
        return root;
    }

    /**
     * 前中后序遍历的递归写法
     */
    public void preOrder(TreeNode node){
        System.out.print(node.val+" ");
        if (node.left!=null)
            preOrder(node.left);
        if (node.right!=null)
            preOrder(node.right);
    }
    public void inOrder(TreeNode node){
        if (node.left!=null)
            inOrder(node.left);
        System.out.print(node.val+" ");
        if (node.right!=null)
            inOrder(node.right);
    }
    public void postOrder(TreeNode node){
        if (node.left!=null)
            postOrder(node.left);
        if (node.right!=null)
            postOrder(node.right);
        System.out.print(node.val+" ");
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}