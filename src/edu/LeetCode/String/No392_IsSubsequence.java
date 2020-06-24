package edu.LeetCode.String;

public class No392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s==null||s.length()==0) return true;
        if (t==null||t.length()==0) return false;
        int sPointer=0,tPointer=0;
        while (true) {
            while (tPointer < t.length() && t.charAt(tPointer) != s.charAt(sPointer)) {
                tPointer++;
            }
            if (tPointer == t.length()) {
                return false;
            } else if (sPointer==s.length()-1){
                return true;
            }
            sPointer++;
            tPointer++;
        }
    }

    public boolean isSubsequence2(String s, String t) {
        if (s==null||s.length()==0) return true;
        if (t==null||t.length()==0) return false;
        int sLen = s.length();
        int index = 0, loc;
        for (int i = 0; i < sLen; i++) {
            loc = t.indexOf(s.charAt(i), index);
            if (loc < 0) return false;
            index = loc + 1;
        }
        return true;
    }
}
