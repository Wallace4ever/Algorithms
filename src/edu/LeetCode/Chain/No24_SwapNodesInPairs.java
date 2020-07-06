package edu.LeetCode.Chain;

public class No24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
        if (head==null||head.next==null) return head;
        ListNode first=head,second=head.next;
        //递归调用得到后面交换完毕的头结点
        ListNode subHead=swapPairs(second.next);
        //完成本次交换
        second.next=first;
        first.next=subHead;
        return second;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
