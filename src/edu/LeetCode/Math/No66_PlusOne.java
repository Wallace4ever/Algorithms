package edu.LeetCode.Math;

public class No66_PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            if(digits[i]==10){
                digits[i]=0;
            }else{return digits;}
        }
        int[] res=new int[digits.length+1];
        res[0]=1;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }
}
