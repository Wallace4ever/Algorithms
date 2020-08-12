package edu.KeyToOffer.TimeSpaceBalance;

import java.util.HashMap;

public class No50_FirstNonRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) return -1;
        int n = str.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < n; i++){
            if(map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
