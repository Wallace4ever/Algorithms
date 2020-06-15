package edu.LeetCode.String;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class No3_LongestSubstringWithoutRepeatingCharacters {
    //建一个长度为128的哈希数组，以字符的ASCII码为索引，出现过的字符对应位置被标记为true。
    // 滑动窗口的左右边界分别从-1开始，内部循环中右边界每访问一个字符就在哈希数组中做标记直到下一个要访问的字符已经出现过，
    // 此时左右边界的距离就是该子串的长度；
    // 接下来外部循环只要不是首次（left=-1）就把之前访问过的字符依次从哈希数组中取消标记，直到那一个重复字符也被取消标记右边界才开始继续向右滑动。
    // 每次左右边界的差值（滑动窗口的大小）的最大值就是满足要求的最长子串的长度。
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) return 0;
        boolean[] hashIndex = new boolean[128];

        int right=-1,maxLen=0;
        for (int left=-1; left<s.length();left++ ) {
            if (left != -1) {
                hashIndex[s.charAt(left)]=false;
            }
            while (right + 1 < s.length() && !hashIndex[s.charAt(right + 1)]) {
                hashIndex[s.charAt(right + 1)]=true;
                right++;
            }
            maxLen=Math.max(maxLen,right-left);
        }
        return maxLen;
    }
}
