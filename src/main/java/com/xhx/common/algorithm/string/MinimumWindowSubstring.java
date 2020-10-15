package com.xhx.common.algorithm.string;
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
    // If there is no such window in S that covers all characters in T, return the empty string "".
    // If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c,0);
        }

        for(Character c:t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                return "";
            }
        }

        int start = 0;
        int end =0;
        int minStart=0;
        int minLength=Integer.MAX_VALUE;
        int counter=t.length();

        for(;end<s.length();){
            if(map.get(s.charAt(end))>0){
                counter--;
            }
            map.put(s.charAt(end),map.get(s.charAt(end))-1);
            end++;
            while (counter==0){
                if(end-start<minLength){
                    minLength=end-start;
                    minStart=start;
                }
                map.put(s.charAt(start),map.get(s.charAt(start))+1);
                if(map.get(s.charAt(start))>0){
                    counter++;
                }
                start++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minStart + minLength);
    }
}
