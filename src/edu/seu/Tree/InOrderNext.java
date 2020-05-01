package edu.seu.Tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class InOrderNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right!=null){//该节点右子树非空则中序遍历的下一节点为右子树的最左节点
            TreeLinkNode cur=pNode.right;
            while (cur.left!=null){
                cur=cur.left;
            }
            return cur;
        }
        //右子树为空则向上判断父节点情况
/*      这部分已经被下面的while覆盖
        if (pNode.next==null)//父节点为空则该点本身为根节点，没有中序遍历的下一节点
            return null;
        if (pNode.next.left==pNode){//如果该节点是父节点的左子树则下一节点就是父节点
            return pNode.next;
        }*/
        while (pNode.next!=null){//网上寻找直至某一父节点是其父节点的左子树
            if (pNode.next.left==pNode)
                return pNode.next;
            pNode=pNode.next;
        }
        //如果找到最后父节点都不是其父节点的左子树，则没有中序遍历下一节点
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}