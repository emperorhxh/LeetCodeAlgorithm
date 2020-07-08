package com.xhx.common.algorithm.backtracing;// Write a function to generate the generalized abbreviations of a word.

// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        List<String> res= generateAbbreviations("word");
        for (String s:res){
            System.out.println(s);
        }
    }
    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        backtrack(result,word,0,"",0);
        
        return result;
    }
    
    static void backtrack(List<String> res,String word,int index,String current,int continuanceCount){
        if(index == word.length()){
            if(continuanceCount>0){
                current +=continuanceCount;
            }
            res.add(current);
        }else {
            backtrack(res,word,index+1,current,continuanceCount+1);
            backtrack(res,word,index+1,current+(continuanceCount>0?continuanceCount:"")+word.charAt(index),0);
        }
    }
}
