package edu.LeetCode.Chain;

public class No25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return a;
            b = b.next;
        }
        ListNode newHead = reverseInRange(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverseInRange(ListNode head, ListNode tailNext){
        ListNode pre = null, cur = head;
        while (cur != tailNext) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
