package edu.KeyToOffer.KnowledgeMigration;

import org.junit.Test;

public class No58_ReverseWords {
    public String reverseWords0(String s) {
        if (s == null || s.length() == 0) return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals(""))
                sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            while (i < s.length() && s.charAt(i) == ' '){
                i++;
            }
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(' ');
        }
        if (sb.length() == 0) return "";
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ')
            sb.deleteCharAt(sb.length() - 1);
        partialReverse(sb, 0, sb.length() - 1);
        int left = 0, right = 0;
        while (right < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') {
                right++;
            }
            partialReverse(sb, left, right - 1);
            left = right + 1;
            right++;
        }
        return sb.toString();
    }

    private void partialReverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char c = sb.charAt(right);
            sb.setCharAt(right, sb.charAt(left));
            sb.setCharAt(left, c);
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        System.out.println(reverseWords(" ")+"1");
    }
}
