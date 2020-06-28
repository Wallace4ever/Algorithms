package edu.LeetCode.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class No129_SumRootToLeafNumbers {
    int total=0;
    public int sumNumbers(TreeNode root) {
        traversal(root,0);
        return total;
    }

    private void traversal(TreeNode current, int sum) {
        if (current != null) {
            sum=sum*10+current.val;
            if (current.left == null && current.right == null) {
                total += sum;
            } else {
                if (current.left!=null)
                    traversal(current.left,sum);
                if (current.right!=null)
                    traversal(current.right,sum);
            }
        }
    }

    public int sumNumbers2(TreeNode root) {
        if (root==null) return 0;
        int total=0;
        Deque<NodeWithSum> stack = new LinkedList<>();
        stack.push(new NodeWithSum(0,root));
        while (!stack.isEmpty()) {
            NodeWithSum current=stack.pop();
            int sum=current.lastSum *10+current.node.val;
            if (current.node.left == null && current.node.right == null) {
                total += sum;
            } else {
                if (current.node.right!=null)
                    stack.push(new NodeWithSum(sum,current.node.right));
                if (current.node.left != null)
                    stack.push(new NodeWithSum(sum,current.node.left));
            }
        }
        return total;
    }

    private class NodeWithSum {
        int lastSum;
        TreeNode node;

        public NodeWithSum(int lastSum, TreeNode node) {
            this.lastSum = lastSum;
            this.node = node;
        }
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        No129_SumRootToLeafNumbers ins=new No129_SumRootToLeafNumbers();
        System.out.println(ins.sumNumbers2(root));;
    }
}
