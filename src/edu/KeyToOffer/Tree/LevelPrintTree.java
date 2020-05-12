package edu.KeyToOffer.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class LevelPrintTree {
    ArrayList<ArrayList<Integer> > PrintReverse(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        if (pRoot==null) return a;
        Queue<TreeNode> q=new LinkedList<>();//当前层的节点所在的队列
        Queue<TreeNode> buffer=new LinkedList<>();//当前层子结点在的队列
        q.offer(pRoot);
        while (true){
            ArrayList<Integer> list=new ArrayList<>();//每次使用一个ArrayList存储当前层节点的遍历结果
            while (!q.isEmpty()){//遍历当前层所有节点并将他们的子结点放入缓冲区中
                TreeNode tmp=q.poll();
                list.add(tmp.val);
                if (tmp.left!=null)
                    buffer.offer(tmp.left);
                if (tmp.right!=null)
                    buffer.offer(tmp.right);
            }
            a.add(list);//当前层遍历结束时将结果ArrayList存储到总结果中
            if (buffer.isEmpty())//这时如果缓冲区为空，说明已经没有下一层的节点
                break;
            q.addAll(buffer);//缓冲区不为空则将缓冲区中的值转存到当前层中，清空缓冲区开始下一层的遍历
            buffer.clear();
        }
        //要按“之”字型层次遍历，可以将总结果中奇数行的结果反转（从0行开始）
/*        for (int i=1;i<a.size();i+=2){
            Collections.reverse(a.get(i));
        }*/
        return a;
    }
}
