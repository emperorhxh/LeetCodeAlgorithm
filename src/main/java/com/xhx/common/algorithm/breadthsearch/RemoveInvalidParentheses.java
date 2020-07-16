package com.xhx.common.algorithm.breadthsearch;

// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

// Note: The input string may contain letters other than the parentheses ( and ).

// Examples:
// "()())()" -> ["()()()", "(())()"]
// "(a)())()" -> ["(a)()()", "(a())()"]
// ")(" -> [""]

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses=new RemoveInvalidParentheses();
        List<String> list = removeInvalidParentheses.removeInvalidParentheses("()())()");
        for(String s:list){
            System.out.println(s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s,result,0,0,'(',')');
        return result;
    }

    private void remove(String s,List<String> result,int last_i,int last_j,char left,char right){
        for(int stack=0,i=last_i;i<s.length();i++){
            if(s.charAt(i) == left){
                stack++;
            }
            if(s.charAt(i) == right){
                stack--;
            }
            if(stack >= 0){
                continue;
            }
            for(int j=last_j;j<=i;j++){
                if(s.charAt(j) == right && (j == last_j || s.charAt(j-1) !=right)){
                    remove(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,left,right);
                }
            }
            return;
        }
        String reverse =new StringBuilder(s).reverse().toString();

        if(left == '('){
            remove(reverse,result,0,0,')','(');
        }else {
            result.add(reverse);
        }
    }

}
