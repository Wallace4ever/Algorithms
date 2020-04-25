package edu.seu.Collections;
import java.util.ArrayList;
class Bucket{
    int key;
    Bucket next;
    public Bucket(int v){key=v;}
    public Bucket(){}
}
public class MyHashSet {
    ArrayList<Bucket> b;
    /** Initialize your data structure here. */
    public MyHashSet() {
        b=new ArrayList<Bucket>(100);
    }

    public void add(int key) {
        int hashValue=key%100;
        Bucket target=new Bucket(key);
        if (b.get(hashValue)==null){
            b.set(hashValue,target);
        }else{
            Bucket cur=b.get(hashValue);
            while(cur.key!=target.key&&cur.next!=null){
                cur=cur.next;
            }
            if(cur.key!=target.key){cur.next=target;}
        }
    }

    public void remove(int key) {
        int hashValue=key%100;
        if(b.get(hashValue)!=null){//如果ArrayList中由该key计算出hashValue对应的位置为空，则什么都不做
            Bucket cur=b.get(hashValue);
            if(cur.next==null&&cur.key==key){//第一种情况：该位置不为空且存储的值没有形成链表，（1.1）若该值与key不同则什么都不做，（1.2）与key相同则调用ArrayList类b对象的remove方法清除该Bucket
                Bucket wasted=b.remove(hashValue);
            }else if(cur.next!=null&&cur.key==key){//第二种情况：该位置存储的值是链表的开头，则需要分别考虑要删除的值在链表开头、中间、结尾以及删除的值不在链表中的情况
                Bucket wasted=b.set(hashValue,cur.next);//（2.1）要删除的值在链表开头，则调用b对象的set方法把该存储位置的引用设为链表下一节点，注意该方法返回的是被替换掉的节点
            }else{
                Bucket temp=new Bucket();
                while(cur.next!=null){//顺着链表继续寻找，直到找到存储的值等于要删除的值的节点或链表最后一个节点
                    if(cur.key!=key){
                        temp=cur;
                        cur=cur.next;
                        continue;
                    }
                    else{//（2.2）要删除的值存储在链表中间
                        temp.next=cur.next;
                        cur.key=-1;
                        break;
                    }
                }
                if(cur.key==key){//while执行完成后指针已经移动到链表尾端，还需要再验证最后一个节点的key，
                    temp.next=null;//（2.3）要删除的节点在链表末尾，直接清除倒数第二个节点中的引用
                }//（2.4）不在则什么都不做
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashValue=key%100;
        if(b.get(hashValue)==null){return false;}
        Bucket cur=b.get(hashValue);
        do{
            if (cur.key==key){return true;}
            if(cur.next==null){return false;}
            else{cur=cur.next;}
        }while(true);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */