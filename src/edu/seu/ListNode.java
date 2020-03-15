package edu.seu;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei=0;
        ListNode result=new ListNode(0);
        ListNode p=result;
        while(l1!=null&&l2!=null){
            p.val=l1.val+l2.val+jinwei;
            if(p.val>9){
                jinwei=p.val-9;
                p.val=9;
            }else{
                jinwei=0;
            }
            if(l1.next==null&&l2.next!=null){
                l1.next=new ListNode(0);
                l1=l1.next;
                l2=l2.next;
            }else if(l2.next==null&&l1.next!=null){
                l2.next=new ListNode(0);
                l1=l1.next;
                l2=l2.next;
            }
            else{
                if(jinwei==0){
                    p.next=null;
                    return result;
                }else{
                    p.next=new ListNode(jinwei);
                    return result;
                }
            }
        }
        return result;
    }
}