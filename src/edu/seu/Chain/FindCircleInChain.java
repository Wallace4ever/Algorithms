package edu.seu.Chain;

/**
 * 判断链表是否有环，并返回环开始的节点
 */
public class FindCircleInChain {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow=pHead,fast=pHead;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                slow=pHead;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
