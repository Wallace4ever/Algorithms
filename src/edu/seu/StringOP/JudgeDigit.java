package edu.seu.StringOP;
import java.util.regex.*;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 编写正则表达式来判断
 */
public class JudgeDigit {
    public boolean isNumeric(char[] str) {
        String s=new String(str);
        Pattern p=Pattern.compile("[+\\-]?\\d*(\\.\\d+)?([Ee][+\\-]?\\d+)?");
        Matcher m=p.matcher(s);
        return m.matches();
    }
}
