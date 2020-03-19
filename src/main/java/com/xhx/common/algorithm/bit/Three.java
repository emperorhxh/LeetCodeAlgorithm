package com.xhx.common.algorithm.bit;

public class Three {
    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * @param n
     * @return
     */
    private static boolean isPowerOfThree(int n){
        return n>0&&(Math.pow(3,19) %n == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));

    }
}
