package edu.KeyToOffer.Sort_Search;

public class BinarySearch {
    public static int iterative(int[] a, int data){
        int low=0,high=a.length-1,mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if (a[mid]==data){
                return mid;
            }else if(a[mid]<data){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static int recursive(int[] a, int data,int low,int high){
        if(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==data){
                return mid;
            }else if(a[mid]<data){
                return recursive(a,data,mid+1,high);
            }else{
                return recursive(a,data,low,mid-1);
            }
        }else{
            return -1;
        }

    }
}
