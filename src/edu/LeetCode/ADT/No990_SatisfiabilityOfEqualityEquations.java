package edu.LeetCode.ADT;

public class No990_SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf=new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0)-97,equation.charAt(3)-97);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && uf.find(equation.charAt(0)-97)==uf.find(equation.charAt(3)-97)) {
                return false;
            }
        }
        return true;
    }

    private class UnionFind {
        private int[] parent;

        //构造时，parent指向自身
        public UnionFind(int length) {
            parent=new int[length];
            for (int i = 0; i < length; i++) {
                parent[i]=i;
            }
        }

        //一次find过程也是做一次隔代压缩
        public int find(int index) {
            while (index != parent[index]) {
                parent[index]=parent[parent[index]];
                index=parent[index];
            }
            return index;
        }

        public void union(int x, int y) {
            int rootX=find(x);
            int rootY=find(y);
            parent[rootX]=rootY;
        }
    }

    public static void main(String[] args) {
        No990_SatisfiabilityOfEqualityEquations in=new No990_SatisfiabilityOfEqualityEquations();
        System.out.println(in.equationsPossible(new String[]{"a==b", "b!=a"}));
    }

}