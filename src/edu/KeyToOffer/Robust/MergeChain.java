package edu.KeyToOffer.Robust;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeChain {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //防御性编程
        if (list1 == null) {
            return list2;
        }else if (list2 == null) {
            return list1;
        }

        //初始化合成后链表的头部
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head=list2;
            list2=list2.next;
        }

        //依次遍历并比较list1和list2中的节点，使用pointer来连接
        ListNode pointer=head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                pointer=pointer.next;
                list1 = list1.next;
            } else {
                pointer.next=list2;
                pointer=pointer.next;
                list2=list2.next;
            }
        }
        //循环结束时如有list还没有遍历完则把剩下的连接到合成链表尾部
        if (list1 != null) {
            pointer.next=list1;
        }
        if (list2 != null) {
            pointer.next=list2;
        }
        return head;
    }
}
