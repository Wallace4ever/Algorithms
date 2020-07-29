package edu.KeyToOffer.Visualization;

public class VerifySequenceOfBST {
    public boolean verifySequenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, -1, sequence.length);
    }

    //左右边界为开区间
    private boolean verify(int[] sequence, int left, int right) {
        if (right-left <= 1) return true;
        int root = sequence[right-1];
        int mid = left;
        while (true) {
            //如果下一个值开始大于根节点就停止循环
            if (sequence[mid+1]>root) break;
            //如果下一个值就是根节点也停止循环
            if (mid+2==right) break;
            mid++;
        }
        //最终mid是包含左子树元素的最后一个
        for (int i = mid+1; i < right-1; i++) {
            if (sequence[i] < root) return false;
        }
        //如果左子树为空则mid=left，下一层递归中mid+1-left=left+1-left==1，返回true
        //如果右子树为空则mid=right-2，下一层递归中right-1-(right-2)==1，返回true
        return verify(sequence, left, mid+1) && verify(sequence, mid , right - 1);
    }
}
