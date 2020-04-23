package edu.seu;

/**
 * 矩阵中的路径：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如a b c e s f c s a d e e (3X4)
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInMatrix {
    boolean[]isVisited=null;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        isVisited=new boolean[rows*cols];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (findPath(matrix,rows,cols,str,i,j,0))
                    return true;
            }
        }
        return false;
    }

    public boolean findPath(char[] matrix, int rows, int cols,char[] str,int currentRow, int currentCol, int matchCursor){
        if(matrix[cols*currentRow+currentCol]!=str[matchCursor]||isVisited[rows*currentRow+currentCol])
            return false;
        if (matchCursor==str.length-1){
            return true;
        }
        isVisited[cols*currentRow+currentCol]=true;
        if (currentRow>0&&findPath(matrix,rows,cols,str,currentRow-1,currentCol,matchCursor+1))
            return true;
        if (currentRow<rows-1&&findPath(matrix,rows,cols,str,currentRow+1,currentCol,matchCursor+1))
            return true;
        if (currentCol>0&&findPath(matrix,rows,cols,str,currentRow,currentCol-1,matchCursor+1))
            return true;
        if (currentCol<cols-1&&findPath(matrix,rows,cols,str,currentRow,currentCol+1,matchCursor+1))
            return true;
        isVisited[cols*currentRow+currentCol]=false;
        return false;
    }

    public static void main(String[] args) {
        String s="ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS"                ;
        String dest="SGGFIECVAASABCEHJIGQEM";
        PathInMatrix p=new PathInMatrix();
        System.out.println(p.hasPath(s.toCharArray(),5,8,dest.toCharArray()));
    }
}
