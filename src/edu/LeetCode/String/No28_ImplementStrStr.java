package edu.LeetCode.String;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 */
public class No28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle==null||needle.length()==0) return 0;
        if (haystack==null||haystack.length()==0) return -1;
        char first=needle.charAt(0);
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == first && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    //滚动哈希法
    public int strStr2(String haystack, String needle) {
        if (needle==null||needle.length()==0) return 0;
        if (haystack==null||haystack.length()==0) return -1;
        int n=haystack.length(),m=needle.length();
        if (n<m) return -1;

        int haystackHash=initialHash(haystack,m),needleHash=initialHash(needle,m);
        for (int i = 0; i <= n - m; i++) {
            if (i != 0) {
                haystackHash=haystackHash-(int)haystack.charAt(i-1)+(int)haystack.charAt(i+m-1);
            }
            if (haystackHash == needleHash && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    private int initialHash(String str, int endIndex) {
        int hash=0;
        for (int i = 0; i < endIndex; i++) {
            hash+=((int)str.charAt(i)-(int)'a');
        }
        return hash;
    }
}
