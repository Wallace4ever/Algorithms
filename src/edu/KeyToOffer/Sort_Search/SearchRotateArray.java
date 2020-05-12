package edu.KeyToOffer.Sort_Search;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class SearchRotateArray {
    /**
     *暴力从左往右搜索
     */
    public int minNumberInRotateArray(int [] array) {
        switch (array.length){
            case 0:
                return 0;
            case 1:
                return array[0];
        }
        for (int p=0;p<array.length-1;p++){
            if (array[p+1]<array[p])
                return array[p+1];
        }
        return array[array.length-1];
    }

    /**
     *使用二分的思想来查找，是二分查找变种，没有具体的目标值用来比较。
     *用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
     */
    public int minNumInRotateArray(int[] array){
        switch (array.length){
            case 0:
                return 0;
            case 1:
                return array[0];
        }
        int low=0,high=array.length-1;
        while(array[low]==array[high]&&low<high){//首先将递增序列左侧和递减序列右侧可能相同的值排除在外
            low++;
            high--;
        }
        while (array[low]>array[high]){
            int mid=(low+high)/2;
            if (array[mid]>=array[low]){//中间值在递增序列中
                low=mid+1;
            }else if(array[mid]<=array[high]){
                high=mid;
            }
        }
        return array[low];
    }
}
