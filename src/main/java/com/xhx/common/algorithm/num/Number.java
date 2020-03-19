package com.xhx.common.algorithm.num;

public class Number {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * @param nums
     * @return
     */
    public  static int missNumber(int[] nums){

        int res = 0;
        int i=0;
        for(;i<nums.length;i++){
            res = res^i^nums[i];
        }
        //将少了一个数的数组与 0 到 n 之间完整的那个数组进行异或处理，因为相同的数字异或会变为了 0 ，那么全部数字异或后，剩下的就是少了的那个数字。
        return res^i;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public static void moveZeroes(int[] nums){
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                nums[k++]=nums[i];
        }
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public  static void main(String[] arg){
        System.out.println(true&&false);

    }
}
