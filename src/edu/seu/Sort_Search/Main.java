package edu.seu.Sort_Search;

public class Main {

    public static void main(String[] args) {
        /*测试几种排序算法与二分查找*/
        int[] a={44,3,38,5,47,3,36,26,27,2,46,4,4,19,48};
        int[] b=CustomSort.sort(a,5);
        for (int x:b){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(BinarySearch.iterative(b,19));
        System.out.println(BinarySearch.recursive(b,19,0,b.length-1));
        GcdOfArray g=new GcdOfArray();
        g.getGcd();
    }
}