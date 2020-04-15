package edu.seu;

import java.util.Scanner;
class Node{
    public int data;
    public Node next;
    public Node(int d){data=d;}
}

public class CycleDelete{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int n=s.nextInt();
            n=(n<=1000)?n:999;
            Node head=new Node(0);
            Node current=head;
            for(int i=1;i<n;i++){
                Node nd=new Node(i);
                current.next=nd;
                current=nd;
            }
            current.next=head;
            current=head;
            Node del=current.next.next;
            while(del!=current){
                current.next.next=del.next;
                current=current.next.next;
                del=current.next.next;
            }
            System.out.println(current.next.data);
        }
    }
}
