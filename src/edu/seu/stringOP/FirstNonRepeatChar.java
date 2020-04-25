package edu.seu.stringOP;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

/**
 * 法一：存储所有字符，然后再进行遍历判断
 */
public class FirstNonRepeatChar {
    List<CharaCount> list=new LinkedList<CharaCount>();
    char currentFirst='#';
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        boolean flag=false;
        for(CharaCount cc:list){
            if (cc.getC()==ch){
                cc.setCount(cc.getCount()+1);
                flag=true;
                break;
            }
        }
        if (!flag){
            CharaCount ncc=new CharaCount(ch,1);
            list.add(ncc);
        }
        for (CharaCount cc:list){
            if (cc.getCount()==1){
                currentFirst=cc.getC();
                return;
            }
        }
        currentFirst='#';
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return currentFirst;
    }
}

class CharaCount{
    private char c;
    private int count;

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public CharaCount(char c,int count){
        this.c=c;
        this.count=count;
    }
}

/**
 * 法二：利用 Hash 思想采用128大小的计数数组进行计数，使用队列这一结构，先出现的不重复字符先输出
 */
class Solution {
    int[] charCnt = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charCnt[ch]++ == 0) //新来的单身字符，入队
            queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Character CHAR = null;
        char c = 0;
        while ((CHAR = queue.peek()) != null) {
            c = CHAR.charValue();
            if (charCnt[c] == 1) //判断是否脱单了，没脱单则输出
                return c;
            else queue.remove(); //脱单了就移出队列，它不会再回来了
        }
        return '#'; //队空，返回#
    }
}