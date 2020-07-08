package edu.LeetCode.BinarySearch;

public class No278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int left=1,right=n;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
