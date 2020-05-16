package edu.KeyToOffer.Robust;

/**
 * 反转链表，注意输入为空指针或链表只有一个节点时的情况
 * 注意三个指针在初始和结束情况下的状态
 */
public class ReverseChain {
    public ListNode ReverseList(ListNode head) {
        //防御型编程
        if (head==null||head.next==null)
            return head;
        ListNode pre=null,cur=head,post=cur.next;
        while (post != null) {
            //开始反转
            cur.next=pre;
            //移动三个指针
            pre=cur;
            cur=post;
            post=post.next;
        }
        //最后一次移动后post指向末尾节点的next，cur指向末尾节点，pre指向倒数第二个节点，此时还需要做一次反转
        cur.next=pre;
        return cur;
    }
}