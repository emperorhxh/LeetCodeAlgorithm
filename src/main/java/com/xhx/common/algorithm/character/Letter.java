package com.xhx.common.algorithm.character;

public class Letter {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 你可以假设字符串只包含小写字母。
     * @param a
     * @param b
     * @return
     */
    public static boolean isAnagram(String a,String b){
        if(a.length() != b.length()) return false;
        int[] counter = new int[26];
        for(char c:a.toCharArray()){
            counter[c-'a']++;
        }
        for (char c:b.toCharArray()){
            counter[c-'a']++;
            if(counter[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
