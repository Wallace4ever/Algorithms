package edu.seu.Chain;

public class AddTwoNumbers {
    int carry=0;
    ListNode result=new ListNode(0);
    ListNode head=result;
    ListNode p1;
    ListNode p2;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        p1=l1;
        p2=l2;
        while(p1.next!=null&&p2.next!=null){//只要同时非空指针就向后移动
            add(0);
            iterate(0);
        }
        //出现了空指针首先执行最后一次3元加法，再判断情况并继续处理
        add(0);
        if(p1.next==null&&p2.next==null){//A）同时为空
            return checkBeforeReturn();
        }
        if(p1.next==null){//B）p1.next为空
            while(p2.next!=null){
                iterate(2);
                add(2);
            }
            return checkBeforeReturn();
        }
        if(p2.next==null){//C）p2.next为空
            while(p1.next!=null){
                iterate(1);
                add(1);
            }
            return checkBeforeReturn();
        }
        return head;
    }

    private void add(int mode){//根据情况选择加法的操作数
        switch (mode){
            case 0:
                result.val=p1.val+p2.val+ carry;
                break;
            case 1:
                result.val=p1.val+ carry;
                break;
            case 2:
                result.val=p2.val+ carry;
                break;
        }
        if(result.val>9){
            carry =1;
            result.val=result.val-10;
        }else{
            carry =0;
        }
    }

    private void iterate(int mode){//根据情况向后迭代
        switch(mode){
            case 0:
                p1=p1.next;
                p2=p2.next;
                break;
            case 1:
                p1=p1.next;
                break;
            case 2:
                p2=p2.next;
                break;
        }
        result.next=new ListNode(0);
        result=result.next;
    }

    private ListNode checkBeforeReturn(){
        if(carry !=0){
            result.next=new ListNode(carry);
        }
        return head;
    }
}
