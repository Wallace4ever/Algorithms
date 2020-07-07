package edu.LeetCode.Chain;

public class No328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(),pointer1=head,pointer2=dummy;

        ListNode odd=new ListNode(),even;
        while (pointer1 != null && pointer1.next != null) {
            odd = pointer1;
            even = pointer1.next;
            odd.next = even.next;
            pointer1 = odd.next;

            pointer2.next = even;
            pointer2 = pointer2.next;
            pointer2.next = null;
        }
        if (pointer1 == null) {
            odd.next = dummy.next;
        } else {
            pointer1.next=dummy.next;
        }
        return head;
    }
}
