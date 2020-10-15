package com.xhx.common.algorithm.string;
// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100"

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();

        int carry =0;
        int al=a.length()-1;
        int bl=b.length()-1;
        while (al >=0||bl>=0){
            int sum=carry;
            if(al>=0){
                sum+=a.charAt(al)-'0';
                al--;
            }
            if(bl>=0){
                sum+=b.charAt(bl)-'0';
            }
            sb.append(sum%2);
            carry=sum/2;
        }

        if(carry==1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
