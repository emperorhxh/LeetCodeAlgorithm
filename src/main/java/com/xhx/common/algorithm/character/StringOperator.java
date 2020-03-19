package com.xhx.common.algorithm.character;

public class StringOperator {

    /**
     * 反转字符串
     * @param s
     * @return
     */
    public static char[] reverse(char[] s){

        int i=0,j=s.length-1;
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }
}
