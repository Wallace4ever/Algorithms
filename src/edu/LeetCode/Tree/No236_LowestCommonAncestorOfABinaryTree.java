package edu.LeetCode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No236_LowestCommonAncestorOfABinaryTree {
    TreeNode ancestor=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        containsPQ(root,p.val,q.val);
        return ancestor;
    }

    private boolean containsPQ(TreeNode root,int p,int q) {
        if (root==null) return false;
        boolean leftContains=containsPQ(root.left,p,q);
        boolean rightContains=containsPQ(root.right,p,q);
        if ((leftContains && rightContains) || ((root.val == p || root.val == q) && (leftContains || rightContains))) {
            ancestor=root;
        }
        return leftContains||rightContains||root.val==p||root.val==q;
    }

    //迭代解法，传递路径时直接复制stack有问题，而是得每次传递一个拷贝
    //另一种思路是我们可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，
    // 再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
/*    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==null||q==null) return null;
        List<TreeNode> pList=null;
        List<TreeNode> qList=null;
        Deque<TreeNode> stack=new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                if (root.val==p.val)
                    pList=new LinkedList<>(stack);
                if (root.val==q.val)
                    qList=new LinkedList<>(stack);
                root=root.left;
            }
            if (stack.isEmpty())
                break;
            root=stack.peek();
            if (root.right != null) {
                root = root.right;
            } else {
                stack.pop();
                root=stack.pop();
            }
        }
        ancestor=pList.get(pList.size()-1);
        for (int i = 1; i <= Math.min(pList.size(), qList.size()); i++) {
            if (pList.get(pList.size()-i)!=qList.get(qList.size()-i))
                break;
            else
                ancestor=pList.get(pList.size()-i);
        }
        return ancestor;
    }*/

}
