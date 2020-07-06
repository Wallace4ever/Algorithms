package edu.LeetCode.Chain;

import java.util.ArrayDeque;
import java.util.Deque;

public class No206_ReverseLinkedList {

    //使用了栈
    public ListNode reverseList0(ListNode head) {
        if (head==null||head.next==null) return head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head.next != null) {
            stack.push(head);
            head=head.next;
        }
        ListNode newHead=head;
        while (!stack.isEmpty()) {
            head.next=stack.pop();
            head=head.next;
        }
        head.next=null;
        return newHead;
    }

    //迭代写法
    public ListNode reverseList2(ListNode head) {
        ListNode prev=null,curr=head;
        while (curr != null) {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    //递归写法
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
