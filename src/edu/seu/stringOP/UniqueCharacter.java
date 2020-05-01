package edu.seu.stringOP;

import java.util.Scanner;
import java.util.ArrayList;
public class UniqueCharacter {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNextLine()){
            String str=s.nextLine();
            char[] c=str.toCharArray();
            ArrayList<Character> a=new ArrayList<Character>();
            for(int i=0;i<c.length;i++){
                if(!a.contains(c[i])){
                    a.add(c[i]);
                }
            }
            for(Character c0:a){
                System.out.print(c0);
            }
            System.out.println();
        }
    }
}

/*public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] c = in.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<c.length;i++){
                if(set.add(c[i]))
                    sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}*/