package edu.LeetCode.String;

public class No387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        //题目假定该字符串只包含小写字母，则只需要26个位置
        int[] hash = new int[26];
        for(int i=0; i<s.length();i++){
            int ch = (int)s.charAt(i)-(int)'a';
            if(hash[ch]==0){
                hash[ch]=i+1;
            }else{
                hash[ch]=-1;
            }
        }
        for(int i=0;i<s.length();i++){
            int ch = (int)s.charAt(i)-(int)'a';
            if(hash[ch]!=0&&hash[ch]!=-1)
                return i;
        }
        return -1;
    }
}
