package edu.LeetCode.Chain;

public class No237_DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        while(node.next!=null){
            node.val=node.next.val;
            if(node.next.next==null){
                node.next=null;
            }else{
                node=node.next;
            }
        }
    }
}
