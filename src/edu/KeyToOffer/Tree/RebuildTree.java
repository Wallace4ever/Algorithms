package edu.KeyToOffer.Tree;

import java.util.*;

/**
 * 给出一个树的前序遍历和中序遍历结果，还原该二叉树
 */
public class RebuildTree {
    public static void main(String[] args) {
        RebuildTree r=new RebuildTree();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root=r.reConstructBinaryTree(pre,in);
/*        r.preOrder(root);
        System.out.println();
        r.preOrder2(root);
        System.out.println();
        r.inOrder(root);
        System.out.println();
        r.inOrder2(root);
        r.postOrder(root);
        System.out.println();*/
        r.levelOrder(root);
//        r.postOrder2(root);
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
     * 层次遍历
     */
    public void levelOrder(TreeNode node){
        if (node==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            TreeNode tmp=q.poll();
            System.out.print(tmp.val+" ");
            if (tmp.left!=null)
                q.offer(tmp.left);
            if (tmp.right!=null)
                q.offer(tmp.right);
        }
    }

    /**
     * 前中后序遍历的递归写法
     */
    public void preOrder(TreeNode node){
        if (node != null) {
            System.out.print(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(TreeNode node){
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val+" ");
            inOrder(node.right);
        }
    }
    public void postOrder(TreeNode node){
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val+" ");
        }
    }
    /**
     * 前中后序遍历的非递归写法
     */
    public void preOrder2(TreeNode node){
        if (node==null) return;
        Stack<TreeNode> s= new Stack<>();
        while (true){
            while (node!=null){
                System.out.print(node.val+" ");
                s.push(node);
                node=node.left;
            }
            if (s.empty())
                break;
            node=s.pop();
            node=node.right;
        }
    }
    public void inOrder2(TreeNode node){
        if (node==null) return;
        Stack<TreeNode> s= new Stack<>();
        while (true){
            while (node!=null){
                s.push(node);
                node=node.left;
            }
            if (s.empty())
                break;
            node=s.pop();
            System.out.print(node.val+" ");
            node=node.right;
        }
    }
    public void postorderTraversal(TreeNode root) {
        if(root==null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curNode,lastPopedNode=null;
        while(!stack.isEmpty()){
            curNode=stack.peek();
            if((curNode.left==null&&curNode.right==null)||
               (lastPopedNode!=null&&(lastPopedNode==curNode.left||lastPopedNode==curNode.right))){
                System.out.print(stack.pop().val+" ");;
                lastPopedNode=curNode;
            }else{
                if(curNode.right!=null)
                    stack.push(curNode.right);
                if(curNode.left!=null)
                    stack.push(curNode.left);
            }
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}