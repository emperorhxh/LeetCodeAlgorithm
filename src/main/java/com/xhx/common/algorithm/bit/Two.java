package com.xhx.common.algorithm.bit;

public class Two {

    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n){
        return n>0&&((n&(n-1))==0);
    }
}
