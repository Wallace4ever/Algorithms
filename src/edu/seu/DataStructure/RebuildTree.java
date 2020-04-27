package edu.seu.DataStructure;

import java.util.Arrays;

/**
 * 给出一个树的前序遍历和中序遍历结果，还原该二叉树
 */
public class RebuildTree {
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
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}