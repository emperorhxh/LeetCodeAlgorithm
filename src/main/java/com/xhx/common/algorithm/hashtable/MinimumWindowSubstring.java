package com.xhx.common.algorithm.hashtable;
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, 0);
        }
        
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
            } else {
                return "";
            }
        }
        int start =0;
        for (;start<s.length();start++){
            if(map.get(s.charAt(start))>0){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                break;
            }
        }
        int end=start+1;
        int count=t.length();
        count--;
        int minNum=Integer.MAX_VALUE;
        String minStr="";
        while (end<s.length()){
            if(map.get(s.charAt(end))>0){
                count--;
            }
            map.put(s.charAt(end),map.get(s.charAt(end))-1);
            while(count==0){
                if((end-start+1)<minNum){
                    minNum =end-start+1;
                    minStr=s.substring(start,end+1);
                }
                map.put(s.charAt(start),map.get(s.charAt(start))+1);
                if(map.get(s.charAt(start)) >0){
                    count++;
                }
                start++;

            }
            end++;
        }

        return minStr;
    }
}
