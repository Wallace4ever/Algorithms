package edu.LeetCode.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class No112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.left==null&&root.right==null&&root.val==sum) return true;
            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }
        return false;
    }

    //使用栈与DFS实现非递归解
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root==null) return false;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        nodeStack.push(root);
        sumStack.push(0);
        while (!nodeStack.isEmpty()){
            TreeNode current=nodeStack.pop();
            int currentSum=sumStack.pop()+current.val;
            if (current.left == null && current.right == null && currentSum == sum) {
                return true;
            } else {
                if (current.right != null) {
                    nodeStack.push(current.right);
                    sumStack.push(currentSum);
                }
                if (current.left != null) {
                    nodeStack.push(current.left);
                    sumStack.push(currentSum);
                }
            }
        }
        return false;
    }
    //使用栈与DFS实现非递归解2，还有问题
    public boolean hasPathSum3(TreeNode root, int sum) {
        if ((root==null)) return false;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        sumStack.push(0);
        TreeNode lastPopped=null;
        while (true){
            while (root != null) {
                sumStack.push(root.val+sumStack.peek());
                nodeStack.push(root);
                root=root.left;
            }
            if (nodeStack.isEmpty())
                break;
            TreeNode temp=nodeStack.peek();
            int t=sumStack.peek();
            if (temp.right == null ||temp.right==lastPopped) {
                sumStack.pop();
                lastPopped=nodeStack.pop();
                if (temp.left==null&&t == sum) {
                    return true;
                }
            } else {
                root=temp.right;
            }
        };
        return false;
    }
// 基于队列和BFS的解法
//    public boolean hasPathSum4

    public static void main(String[] args) {
        No112_PathSum ins=new No112_PathSum();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(ins.hasPathSum3(root,1));
    }
}
