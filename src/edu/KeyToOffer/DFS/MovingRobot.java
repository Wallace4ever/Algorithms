package edu.KeyToOffer.DFS;

/**
 * 机器人的运动范围：
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingRobot {
    boolean[][] isVisited=null;
    int count=0;
    public int movingCount(int threshold, int rows, int cols){
        isVisited=new boolean[rows][cols];
        visit(0,0,threshold,rows,cols);
        return count;
    }

    public void visit(int rowIndex,int colIndex,int threshold, int rows, int cols){
        if (getCount(rowIndex)+getCount(colIndex)>threshold||isVisited[rowIndex][colIndex])
            return;
        isVisited[rowIndex][colIndex]=true;
        count++;
        if (rowIndex>0)
            visit(rowIndex-1,colIndex,threshold,rows,cols);
        if (rowIndex<rows-1)
            visit(rowIndex+1,colIndex,threshold,rows,cols);
        if (colIndex>0)
            visit(rowIndex,colIndex-1,threshold,rows,cols);
        if (colIndex<cols-1)
            visit(rowIndex,colIndex+1,threshold,rows,cols);
    }

    public int getCount(int a){
        String s=String.valueOf(a);
        char[] c=s.toCharArray();
        int sum=0;
        for (char cc:c){
            sum+=Integer.parseInt(String.valueOf(cc));
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingRobot mr=new MovingRobot();
        int c=mr.movingCount(18,50,50);
        System.out.println(c);
    }
}
