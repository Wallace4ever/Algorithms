package edu.KeyToOffer.Sort_Search;
import java.util.Arrays;
import java.util.Scanner;

public class GcdOfArray {
    private int[] arr;

    public GcdOfArray() {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter total numbers:");
        int n=s.nextInt();
        System.out.println("Please enter the Integer array:");
        arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
    }

    public void getGcd(){
        boolean flag;
        do{
            Arrays.sort(arr);
            flag=true;
            for (int j=arr.length-1;j>0;j--){
                if (arr[j]%arr[j-1]==0){
                    arr[j]=arr[j-1];
                }else{
                    arr[j]=arr[j]%arr[j-1];
                    flag=false;
                }
            }
        }while (!flag);
        System.out.println(arr[0]);
    }
}
