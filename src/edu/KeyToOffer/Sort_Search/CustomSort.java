package edu.KeyToOffer.Sort_Search;

public class CustomSort {
    public static int[] sort(int[] a, int mode){
        switch (mode) {
            case 1:
                return BubbleSort.sort(a);
            case 2:
                return SelectSort.sort(a);
            case 3:
                return InsertSort.sort(a);
            case 4:
                int[] temp=new int[a.length];
                MergeSort.sort(a,temp,0,a.length-1);
                return a;
            case 5:
                QuickSort.sort(a,0,a.length-1);
            default:
                return a;
        }
    }
}

class BubbleSort{
    public static int[] sort(int[] a){
        int temp;
        while(true){
            boolean flag=false;//设置flag表示该趟排序过程中是否发生了交换，这里for执行完也仅仅是1趟
            for(int p1=0,p2=1;p2<a.length;p1++,p2++){//使用p1 p2来扫描相邻的两个数并按交换小的至左边
                if(a[p1]>a[p2]){
                    flag=true;
                    temp=a[p2];
                    a[p2]=a[p1];
                    a[p1]=temp;
                }
            }
            if (!flag){return a;}//某一趟排序没有发生交换则排序完成
        }
    }
}

class SelectSort{
    public static int[] sort(int[] a){
        for(int i=0;i<a.length-1;i++){//i是剩下待排序序列的最左侧
            int minIndex=i;//初始待排序序列最小值的index设为i
            for (int j=i+1;j<a.length;j++){//使用j来找到剩下待排序的序列中最小值所在的index
                if (a[j]<a[minIndex]){
                    minIndex=j;
                }
            }
            if (minIndex!=i){//交换待排序序列最左侧的值和最小值
                int temp=a[minIndex];
                a[minIndex]=a[i];
                a[i]=temp;
            }
        }
        return a;
    }
}

class InsertSort{
    public static int[] sort(int[] a){
        class InsertList{//内部有序链表类，便于插入
            int value;
            InsertList next;
            public InsertList(){}
            public InsertList(int q){value=q;}
        }

        InsertList s=new InsertList(a[0]);//以数组首元素新建节点
        for (int i=1;i<a.length;i++){//将数组中的剩下的数依次插入链表并排序
            InsertList pointer=s;//每次插入前将pointer和last初始化
            InsertList last=new InsertList();
            while (a[i]>=pointer.value && pointer.next!=null){//当要插入的值大于等于指针指向的节点存储的值且该节点的下一节点不为空时向后移动指针和last
                last=pointer;
                pointer=pointer.next;
            }
            if(a[i]<pointer.value){//循环停止时首先判断要插入的值是否小于指针指向节点的值，是则插入并进入下一次for循环
                last.next=new InsertList(a[i]);
                last.next.next=pointer;
            }else{//最后如果pointer.next为空则新建节点并链接到pointer之后。如果在if中先判断pointer.next则对于[2,1,...]在插入1时就会出现问题
                pointer.next=new InsertList(a[i]);
            }
        }
        for (int i=0;i<a.length;i++){//排序完成将链表中的值存储至数组
            a[i]=s.value;
            if(s.next!=null){s=s.next;}
        }
        return a;
    }
}

class MergeSort{
    public static void sort(int[] a, int[] temp,int left,int right){
        int mid;
        if (right>left){//当数组超过1个元素时拆分（递归调用直至每个子数组都只含一个元素）
            mid=(right+left)/2;
            sort(a,temp,left,mid);
            sort(a,temp,mid+1,right);
            merge(a,temp,left,mid+1,right);//合并两个已经排好序的子数组
        }
    }
    private static void merge(int[] a,int[] temp,int left, int mid,int right){
        int left_end,size,temp_pos;
        left_end=mid-1;//左半部分的结尾
        temp_pos=left;
        size=right-left+1;

        while (left<=left_end && mid<=right){//将a中范围为[left..left_end][mid..right]两部分依次选出最小的放到temp[temp_pos]处
            if(a[left]<=a[mid]){
                temp[temp_pos]=a[left];
                temp_pos+=1;
                left+=1;
            }else{
                temp[temp_pos]=a[mid];
                temp_pos+=1;
                mid+=1;
            }
        }
        //当某一部分全部放到temp中后另一部分可能还有没放完的
        while(left<=left_end){//左半部分的指针还没到底的话
            temp[temp_pos]=a[left];
            temp_pos+=1;
            left+=1;
        }
        while(mid<=right){//右半部分的指针还没到底的话
            temp[temp_pos]=a[mid];
            temp_pos+=1;
            mid+=1;
        }
        //将temp中排好序的部分写回a中对应的位置
        for (int i=0;i<size;i++){
            a[right]=temp[right];
            right-=1;
        }
    }
}

class QuickSort{
    public static void sort(int[] a,int left,int right){
        if(left<right){
            int pivotIndex=partition(a,left,right);
            sort(a,left,pivotIndex-1);
            sort(a,pivotIndex+1,right);
        }
    }

    private static int partition(int[] a, int left, int right){
        int pivot=a[left];
        int l=left,r=right;
        while (l<r){
            while(a[l]<=pivot){l++;}//外部while停止case1:a[l]指向了上一次交换后的a[r],a[r]是第一个大于pivot的值,此时l=r； 停止case 2:a[l]指向了下一个未处理的大于pivot的数
            while(a[r]>pivot){r--;}//停止case1:r-1，则a[r]<=pivot，这时a[r+1]是第一个大于pivot的值,可以将a[left]和a[r]交换； 停止case :r=l时没问题，r=l-1时停止，此时a[r+1]依然是是第一个大于pivot的值,可以将a[left]和a[r]交换
            if(l<r){
                int temp=a[l];
                a[l]=a[r];
                a[r]=temp;
            }
        }//不会出现l=r的情况
        a[left]=a[r];
        a[r]=pivot;
        return r;
    }
}

/*
class ShellSort{
    public static int[] sort(int[] a){

    }
}


class HeapSort{
    public static int[] sort(int[] a){

    }
}


*/
