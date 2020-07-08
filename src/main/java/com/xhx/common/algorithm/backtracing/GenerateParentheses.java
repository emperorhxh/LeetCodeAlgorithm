package com.xhx.common.algorithm.backtracing;
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
  //"((()))",
  //"(()())",
  //"(())()",
  //"()(())",
  //"()()()"
//]

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        List<String> res= generateParenthesis(3);
        for (String s:res){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesisRecursive(result,"",0,0,n);
        
        return result;
    }
    
    public static void generateParenthesisRecursive(List<String> result,String current,int open,int close,int n) {
       if(current.length() == n*2){
           result.add(current);
           return;
       }
       if(open<n){
           generateParenthesisRecursive(result,current+"(",open+1,close,n);
       }
       if(close<open){
           generateParenthesisRecursive(result,current+")",open,close+1,n);
       }
    }
}
