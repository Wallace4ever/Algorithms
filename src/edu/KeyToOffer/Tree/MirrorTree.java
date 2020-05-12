package edu.KeyToOffer.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 非递归思路是对两个子树进行层次遍历，但左子树每层从左向右遍历，右子树从右向左
 * 过了90%，用例: {5,5,5,5,#,#,5,5,#,5}应为假，但判断为真
 *     5
 *   5   5
 *  5 # # 5
 * 5 #   5 #
 * 于是当节点子结点为空时遍历结果中插入Integer.MIN_VALUE来区别这种情况下的顺序，依然不对很疑惑
 */
public class MirrorTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return levelOrder(pRoot.left,true).equals(levelOrder(pRoot.right,false));
    }

    ArrayList<Integer> levelOrder(TreeNode node,boolean isLeft2Right){
        ArrayList<Integer> resultList=new ArrayList<>();
        if (node==null) return resultList;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            TreeNode tmp=q.poll();
            resultList.add(tmp.val);
            if (isLeft2Right){
                if (tmp.left!=null)
                    q.offer(tmp.left);
                else
                    resultList.add(Integer.MIN_VALUE);
                if (tmp.right!=null)
                    q.offer(tmp.right);
                else
                    resultList.add(Integer.MIN_VALUE);
            }else{
                if (tmp.right!=null)
                    q.offer(tmp.right);
                else
                    resultList.add(Integer.MIN_VALUE);
                if (tmp.left!=null)
                    q.offer(tmp.left);
                else
                    resultList.add(Integer.MIN_VALUE);
            }
        }
        return resultList;
    }
}
