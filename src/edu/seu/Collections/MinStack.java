package edu.seu.Collections;
import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> m;
    int topp;
    Helper hs;//辅助栈，仅当主栈操作了较hs栈顶更小或相同的值时，为该值从辅助栈顶执行相应操作，以实现O(1)查询性能
    /** initialize your data structure here. */
    public MinStack() {
        m=new ArrayList<Integer>();
        topp=-1;
        hs=new Helper();
    }

    public void push(int x) {
        Integer a=x;
        m.add(a);
        topp++;
        hs.setMin(x);
    }

    public void pop() {
        if (topp>=0){
            hs.pop(m.get(topp).intValue());
            m.remove(topp);
            topp--;
        }
    }

    public int top() {
        if(topp>=0){return m.get(topp);}
        else {
            return Integer.MAX_VALUE;
        }
    }

    public int getMin() {
        return hs.top();
    }
}

class Helper{
    ArrayList<Integer> h;
    int topp;

    public Helper(){
        h=new ArrayList<Integer>();
        topp=-1;
    }

    public void setMin(int x){
        if(h.size()==0||h.get(topp)>=x){
            h.add(new Integer(x));
            topp++;
        }
    }

    public void pop(int x) {
        if(x==h.get(topp)){
            h.remove(topp);
            topp--;
        }
    }

    public int top() {
        if(topp>=0) {
            return h.get(topp).intValue();
        } else {
            return Integer.MAX_VALUE;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */