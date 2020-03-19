package com.xhx.common.algorithm.bit;

public class Four {
    /**
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。
     * @param n
     * @return
     */
    private static boolean isPowerOfFour(int n){
        if(n < 0)return false;
        //如果是2的幂次方并且二进制1在奇数位，则为4的幂次方。否则不是
        if((n&(n-1)) != 0) return false;
        if((n&0x55555555) == n) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));

    }
}
