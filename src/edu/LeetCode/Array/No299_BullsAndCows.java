package edu.LeetCode.Array;

import java.util.*;

public class No299_BullsAndCows {
    //
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map=new HashMap<>();
        List<Character> list=new ArrayList<>();
        int bulls=0,cows=0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                list.add(guess.charAt(i));
                if (map.containsKey(secret.charAt(i))) {
                    map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
                } else {
                    map.put(secret.charAt(i), 1);
                }
            }
        }
        for (Character c : list) {
            if (map.containsKey(c)&&map.get(c)>0) {
                cows++;
                map.put(c,map.get(c)-1);
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
    }

    //小优化，使用数组作为哈希
    public String getHint2(String secret, String guess) {
        int[] bullsBucket=new int[10];
        int[] cowsBucket=new int[10];
        int bulls=0,cows=0;

        for (int i = 0; i < secret.length(); i++) {
            char s=secret.charAt(i),g=guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                cowsBucket[g-'0']+=1;
                bullsBucket[s-'0']+=1;
            }
        }
        for (int i=0;i<10;i++) {
            cows+=Math.min(bullsBucket[i],cowsBucket[i]);
        }
        return bulls+"A"+cows+"B";
    }
}
