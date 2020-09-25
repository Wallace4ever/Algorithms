package edu.LeetCode.Chain;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge2Lists(lists[0], lists[1]);

        return merge2Lists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)), mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val <= head2.val) {
            head1.next = merge2Lists(head1.next, head2);
            return head1;
        } else {
            head2.next = merge2Lists(head1, head2.next);
            return head2;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists)
            if(node != null) heap.offer(node);
        ListNode dummy = new ListNode(), pointer = dummy;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (min.next != null) heap.offer(min.next);
            pointer.next = min;
            pointer = pointer.next;
        }
        return dummy.next;
    }
}
