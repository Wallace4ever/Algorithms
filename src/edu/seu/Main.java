package edu.seu;

public class Main {

    public static void main(String[] args) {
//        System.out.println(Cal1.work(100));
//        System.out.println(Cal2.work(100));
/*
        测试自定义链表
        ListNode a=new ListNode(2);
        ListNode s1=a;
        a.next=new ListNode(4);
        a=a.next;
        a.next=new ListNode(3);
        ListNode b=new ListNode(5);
        ListNode s2=b;
        b.next=new ListNode(6);
        b=b.next;
        b.next=new ListNode(4);
        Solution s=new Solution();
        ListNode result=s.addTwoNumbers(s1,s2);
        System.out.println(result.val);
        while(result.next!=null){
            System.out.println(result.val);
            result=result.next;
        }*/
/*
        测试几种排序算法与二分查找
        int[] a={44,3,38,5,47,3,36,26,27,2,46,4,4,19,48};
        int[] b=CustomSort.sort(a,5);
        for (int x:b){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(BinarySearch.iterative(b,19));
        System.out.println(BinarySearch.recursive(b,19,0,b.length-1));*/
        GcdOfArray g=new GcdOfArray();
        g.getGcd();
    }
}

/*
class Cal2{
    public static double work(double n){
        if (n==1) {
            return 9;
        }else {
            return 9*work(n-1);
        }
    }
}

class Cal1{
    public static double work(double n){
        double temp=1;
        for (int i=1;i<=n;i++){
            temp*=9;
        }
        return temp;
    }
}*/
