package edu.LeetCode.ADT;

/**
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * 返回区域的数目。
 */
public class No959_RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int length=grid.length;
        UnionFind uf=new UnionFind(4*length*length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int blockId=i*length+j;
                //合并块内的4个小三角
                switch (grid[i].charAt(j)) {
                    case '/':
                        uf.union(blockId*4,blockId*4+3);
                        uf.union(blockId*4+1,blockId*4+2);
                        break;
                    case '\\':
                        uf.union(blockId*4,blockId*4+1);
                        uf.union(blockId*4+2,blockId*4+3);
                        break;
                    case ' ':
                        uf.union(blockId*4,blockId*4+1);
                        uf.union(blockId*4+1,blockId*4+2);
                        uf.union(blockId*4+2,blockId*4+3);
                        break;
                }
                //合并块间
                if (i>0)//和上方合并
                    uf.union(blockId*4,(blockId-length)*4+2);
                if (i<length-1)//和下方合并
                    uf.union(blockId*4+2,(blockId+length)*4);
                if (j>0)//和左方合并
                    uf.union(blockId*4+3,(blockId-1)*4+1);
                if (j<length-1)//和右方合并
                    uf.union(blockId*4+1,(blockId+1)*4+3);
            }
        }
        return uf.getUniqueTreeCount();
    }

    private class UnionFind{
        int[] parent;

        public UnionFind(int length) {
            parent=new int[length];
            for (int i = 0; i < length; i++) {
                parent[i]=i;
            }
        }

        //由于这题需要给出并查集中数的数目，所以直接使用完全压缩
        public int find(int x) {
            if (parent[x] != x) {
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            parent[rootX]=rootY;
        }

        public int getUniqueTreeCount() {
            int count=0;
            for (int i = 0; i < parent.length; i++) {
                if (i==find(i))
                    count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] s={"\\/","/\\"};
        No959_RegionsCutBySlashes ins=new No959_RegionsCutBySlashes();
        System.out.println(ins.regionsBySlashes(s));
    }
}
