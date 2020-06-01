package edu.KeyToOffer.Robust;

/**
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，则从1一直打印到最大的三位数999。
 * 注意n的范围，以及如果使用整形或长整形表示数则n变大时有溢出风险
 */
public class PrintNumber {
    //调用入口，初始化字符数组并递归填充数组
    public void print(int n) {
        if (n<=0) return;
        char[] num=new char[n];
        print(num,0);
    }

    //递归填充数组的每一位实现全排列
    private void print(char[] num,int index) {
        //传入的下标等于数组长度时填充完毕，调用打印方法
        if (index == num.length) {
            print(num);
            System.out.println();
            return;
        }
        //每次对当前位进行填充并递归填充下一位
        for (int i = 0; i < 10; i++) {
            num[index]=(char)(i+'0');
            print(num,index+1);
        }
    }

    //实际打印方法，通过trim标记避开数组前面的0
    private void print(char[] num) {
        boolean trim=true;
        for (char c : num) {
            if (!(trim && c == '0')) {
                System.out.print(c);
                trim = false;
            }
        }
    }
}