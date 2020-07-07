package edu.LeetCode.Chain;

public class No19_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||n<=0) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode first=head,second=head;
        int count=1;
        ListNode prev=dummy;
        while (first.next != null) {
            first=first.next;
            count++;
            if (count > n) {
                prev=second;
                second=second.next;
            }
        }
        prev.next=second.next;
        return dummy.next;
    }
}
