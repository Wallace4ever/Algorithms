package edu.KeyToOffer.Robust;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 要在设计时采用防御性编程的思想考虑问题中可能存在的陷阱
 */
public class KthNodeFromEnd {
    public ListNode FindKthToTail(ListNode head,int k) {
        //如果输入为空或k值小于1则无意义，返回空
        if (head==null||k<1)
            return null;
        //开始把两个指针的下一节点指向头结点
        ListNode p1=new ListNode(0);
        p1.next=head;
        ListNode p2=p1;
        //p1先移动k次，会指向正数第k个节点。换句话说只要链表存在至少k个节点则循环结束时p1不可能为空
        for (int step = 1; step <= k; step++) {
            p1=p1.next;
            //当循环没结束时如果p1为空则说明p1已到达链表尾端的next，不能再前进，链表节点数小于k，返回空
            if (p1==null)
                return null;
        }
        //循环正常结束时，p1指向正数第k个节点，p2指向正数第0个节点。
        //两个继续移动，当p1指向倒数第0个节点（lastNode.next）即为空时，p2指向倒数第k个节点
        while (p1!= null) {
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
}
