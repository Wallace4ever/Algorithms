package edu.seu;

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