package edu.LeetCode.Chain;

public class No92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode part1Tail=new ListNode(-1),part2Head=new ListNode(-1);
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int count=1;
        ListNode prev=dummy,curr=head;
        while(curr!=null){
            if(count==m){
                //标记
                part1Tail=prev;
                part2Head=curr;
            }
            ListNode temp=curr.next;
            if(count>m&&count<n){
                //翻转
                curr.next=prev;
            }
            if(count==n){
                part2Head.next=curr.next;
                part1Tail.next=curr;
                curr.next=prev;
                break;
            }
            //跳跃
            prev=curr;
            curr=temp;
            count++;
        }
        return dummy.next;
    }
}
