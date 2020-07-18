package edu.LeetCode.BitManipulation;

public class No318_MaximumProductOfWordLengths {
    int[] masks;
    public int maxProduct(String[] words) {
        if (words==null||words.length<2) return 0;
        int n = words.length;

        //预处理，计算每个单词的掩码
        masks=new int[n];
        for (int i = 0; i < n; i++) {
            int mask=0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            masks[i] = mask;
        }

        //计算不含有重复字符的单词的最大长度乘积
        int maxProduct=0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = words[i].length() * words[j].length();
                if (product > maxProduct && !containsSameChar(i,j)){
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private boolean containsSameChar(int i,int j) {
        return (masks[i] & masks[j]) != 0;
    }
}
