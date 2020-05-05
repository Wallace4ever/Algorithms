package edu.seu.StringOP;
import java.util.Scanner;

/**
 * 华为1面动手题：给出Excel表格中用大写字符串表示的列，求出其代表的列数
 */
public class HWInterview {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        char[] b=str.toCharArray();
        int count=0;
        int w=0;
        for (int i=b.length-1;i>=0;i--){
            count+=((int)b[i]-(int) 'A'+1)*Math.pow(26,w);
            w++;
        }
        System.out.println(count);
    }
}
