package edu.KeyToOffer.Robust;

public class DeleteChainNode {
    public void deleteNode(ListNode head, ListNode target) {
        //防御型编程
        if (head==null||target==null) return;

        //如果目标是链表尾
        if (target.next == null) {
            //如果链表只有一个节点
            if (head == target) {
                head=null;
                return;
            }
            ListNode post;
            while (head.next != null) {
                post=head;
                head=head.next;
                if (head == target) {
                    post.next=head.next;
                    return;
                }
            }
        }

        //一般情况,gc会自动回收之前的target.next
        target.val=target.next.val;
        target.next=target.next.next;
    }
}
