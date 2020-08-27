package edu.LeetCode.Chain;

public class No92_ReverseLinkedListII {
    //迭代解法
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode part1Tail = null, part2Head = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            if (count == m) {
                //标记
                part1Tail = prev;
                part2Head = curr;
            }
            ListNode temp = curr.next;
            if (count > m && count < n) {
                //翻转
                curr.next = prev;
            }
            if (count == n) {
                part2Head.next = curr.next;
                part1Tail.next = curr;
                curr.next = prev;
                break;
            }
            //跳跃
            prev = curr;
            curr = temp;
            count++;
        }
        return dummy.next;
    }

    //递归解法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseToNth(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode successor = null;
    public ListNode reverseToNth(ListNode head, int n){
        if(n == 1 || head.next == null){
            successor = head.next;
            return head;
        }

        ListNode newHead = reverseToNth(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}
