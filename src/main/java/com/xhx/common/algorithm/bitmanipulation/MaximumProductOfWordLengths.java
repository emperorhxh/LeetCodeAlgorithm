package com.xhx.common.algorithm.bitmanipulation;
// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

// Example 1:
// Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
// Return 16
// The two words can be "abcw", "xtfn".

// Example 2:
// Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
// Return 4
// The two words can be "ab", "cd".

// Example 3:
// Given ["a", "aa", "aaa", "aaaa"]
// Return 0
// No such pair of words.

public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        String[] words =new String[]{"a", "aa", "aaa", "aaaa"};
        System.out.println(maxProduct(words));
    }
    public static int maxProduct(String[] words) {
        if(words.length == 0 || words == null) {
            return 0;
        }
        int[] temp =new int[words.length];
        for(int i=0;i<temp.length;i++){
            int value=0;
            for(int k=0;k<words[i].length();k++){
                value |= 1<<(words[i].charAt(k)-'a');
            }
            temp[i]=value;
        }
        int max=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if((temp[i] & temp[j]) == 0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
