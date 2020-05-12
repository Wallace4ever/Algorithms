package edu.KeyToOffer.Chain;

public class DeleteSameNode {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode virtualHead=new ListNode(Integer.MIN_VALUE);
        virtualHead.next=pHead;
        ListNode pre=pHead,cur=pHead.next;
        while(cur!=null){
            if (cur.next!=null&&cur.val==cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
                pre.next=cur;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return virtualHead.next;
    }
}