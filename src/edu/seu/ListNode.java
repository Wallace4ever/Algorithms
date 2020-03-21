package edu.seu;
import java.util.*;
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode() { }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//两数之和
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

    public static int removeElement(int[] nums, int val) {//移除元素
        int i=0;
        for(int j=0;j<nums.length;j++){
            while(nums[j]==val){
                if (j==nums.length-1){return i;}
                j+=1;
            }
            nums[i]=nums[j];
            i++;
        }
        return i;
    }

    public int[] plusOne(int[] digits) {//加一
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            if(digits[i]==10){
                digits[i]=0;
                continue;
            }else{return digits;}
        }
        int[] res=new int[digits.length+1];
        res[0]=1;
        for(int i=1;i<=digits.length;i++){
            res[i]=digits[i-1];
        }
        return res;
    }

    public boolean hasCycle(ListNode head) {//环形链表
        if (head==null){return false;}
        ListNode p1=head;
        ListNode p2=head;
        while(p1.next!=null){
            if(p2.next==null||p2.next.next==null){return false;}
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){return true;}
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {//环形链表II
        if (head==null){return null;}
        ListNode p1=head;
        HashSet<ListNode> index=new HashSet<ListNode>();
        while(p1.next!=null){
            if(index.contains(p1)){
                return p1;
            }else{
                index.add(p1);
            }
            p1=p1.next;
        }
        return null;
    }

    public ListNode reverseList(ListNode head) {//反转链表
        if (head==null){return null;}
        ListNode temp,currentHead;
        currentHead=head;
        temp =new ListNode();
        while(head.next!=null){
            if(head.next.next!=null){
                temp.next=head.next.next;
                head.next.next=currentHead;
                currentHead=head.next;
                head.next=temp.next;
            }else{
                head.next.next=currentHead;
                currentHead=head.next;
                head.next=null;
            }
        }
        return currentHead;
    }

    public void reverseString(char[] s) {//反转字符串，时空复杂度OK
        int i=0;
        int j=s.length-1;
        char temp;
        while(i<j){
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    public int findMaxConsecutiveOnes(int[] nums) {//最大连续1的个数
        int maxCount=0;
        int tempCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                tempCount++;
                maxCount=Math.max(maxCount,tempCount);
            }else{
                tempCount=0;
            }
        }
        return maxCount;
    }

    public int arrayPairSum(int[] nums) {//数组拆分I
        java.util.Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length;i+=2){res+=nums[i];}
        return res;
    }

    public int pivotIndex(int[] nums) {//寻找数组的中心索引，时间复杂度不OK
        for(int i=0;i<=nums.length-1;++i){
            int leftsum=0;
            int rightsum=0;
            for(int j=0;j<i;++j){
                leftsum+=nums[j];
            }
            for(int j=i+1;j<=nums.length-1;++j){
                if(j==nums.length)break;
                rightsum+=nums[j];
            }
            if(leftsum==rightsum){return i;}
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int f=0;
        int s=0;
        do{
            f=nums[nums[f]];
            s=nums[s];
        }while(nums[nums[f]]!=nums[s]);
        f=nums[s];
        s=0;
        while(nums[s]!=nums[f]){
            s=nums[s];
            f=nums[f];
        }
        return nums[s];
    }
}