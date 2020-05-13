package edu.KeyToOffer.Robust;

/**
 * 判断链表是否有环，并返回环开始的节点
 * 依然需要用防御性编程增强鲁棒性
 */
public class FindCircleInChain {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null)//原来不加这一句若pHead为空在下面while判断时就会出异常
            return null;
       ListNode slow=pHead,fast=pHead;//其实在初始化时把slow和fast的下一节点指向pHead就能避免while判断的异常了
       //短路可保证while循环内部fast.next.next不为空
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //两者相遇后，重置slow，两者以相同的速度前进相遇的节点就是环开始的节点
            if (fast==slow){
                slow=pHead;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        //当fast走到空节点时两者还没有相遇则不存在环
        return null;
    }
}
//有个简单思路，使用O(n)大小的HashSet辅助空间，遍历链表的节点并依次放入Set中，遇到空指针前如果插入失败则插入的点是环的开始
//但该思路不是本题的考察意图