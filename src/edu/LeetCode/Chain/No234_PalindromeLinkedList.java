package edu.LeetCode.Chain;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class No234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode first = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (first != null) {
            ListNode last = stack.pop();
            if (first.val != last.val) return false;
            first = first.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        ListNode end = reverse(slow);
        while (end != null) {
            if (end.val != head.val) return false;
            end = end.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
