package edu.KeyToOffer.TimeSpaceBalance;

public class No52_FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLen(pHead1), len2 = getLen(pHead2);
        if (len1 == 0 || len2 == 0) return null;
        int diff = len1 - len2;
        //p1指向长的链表，p2指向短的
        ListNode p1 = diff >= 0 ? pHead1 : pHead2, p2 = diff >= 0 ? pHead2 : pHead1;
        diff = Math.abs(diff);
        while (diff-- > 0) {
            p1 = p1.next;
        }
        while (p1 != null) {
            if (p1.val == p2.val) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}