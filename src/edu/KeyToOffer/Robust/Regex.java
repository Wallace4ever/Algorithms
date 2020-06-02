package edu.KeyToOffer.Robust;

public class Regex {
    public boolean match(char[] str,char[] pattern) {
        if (str==null||pattern==null) return false;
        return match(str,0,pattern,0);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //如果字符串与模式都已经匹配到结尾则返回true
        if (strIndex==str.length&& patternIndex==pattern.length) return true;
        //如果模式已经结束，而字符串不为空则返回false
        if (patternIndex==pattern.length) return false;

        //如果模式的下一字符存在，且为*时
        if ((patternIndex + 1)<pattern.length&&pattern[patternIndex + 1] == '*') {
            //如果当前的字符串可访问且与当前模式匹配
            if (strIndex<str.length&&(str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                //*匹配一个该模式字符，字符指针后移，模式进入下一状态（其实这种情况可以不写，可由两次递归表示：多个+0个）
                return //match(str,strIndex+1,pattern,patternIndex+2)||
                        //*匹配多个该模式字符，字符指针后移，模式保持在该状态
                        match(str,strIndex+1,pattern,patternIndex)||
                        //*匹配0个该模式字符，字符指针不变，模式进入下一状态
                        match(str,strIndex,pattern,patternIndex+2);
            } else {
                //当前字符与当前模式不匹配的话说明*匹配0个当前模式，字符指针不变，模式进入下一状态
                return match(str,strIndex,pattern,patternIndex+2);
            }
        }
        //否则如果当前字符串可访问且当前字符串与当前模式匹配则进入下一状态
        if (strIndex<str.length&&(str[strIndex] == pattern[patternIndex]|| pattern[patternIndex] == '.')) {
            return match(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }
}