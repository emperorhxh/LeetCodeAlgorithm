package com.xhx.common.algorithm.num;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * @param points
     * @return
     */
    public  static int numberOfBoomerangs(Point[] points){

        int res = 0;
        for(int i =0;i<points.length;i++){
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i != j){
                    int dis = points[i].dis(points[j]);
                    if(map.containsKey(dis)){
                        map.put(dis,map.get(dis)+1);
                    }else {
                        map.put(dis,1);
                    }
                }
            }

            for(Integer a:map.keySet()){
                int value = map.get(a);
                res+=value*(value-1);
            }
        }
        return  res;
    }

    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     * @param temperatures
     * @return
     */
    public  static int[] dailyTemperatures(int[] temperatures){

        int[] res=new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int j=stack.pop();
                res[j]=i-j;
            }
            stack.add(i);
        }
        return res;
    }

    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     * @return
     */
    public  static int fourSumZeroCount(int[] a,int[] b,int[] c,int[] d){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int sum = a[i]+b[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);

                }else {
                    map.put(sum,1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<c.length;i++){
            for(int j=0;j<d.length;j++){
                int sum = -c[i]-d[j];
                if(map.containsKey(sum)){
                   res+=map.get(sum);

                }
            }
        }

        return res;
    }

    /**
     * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
     * @param a
     * @param k
     * @return
     */
    public  static int twoSumLessThanK(int[] a,int k){
        Arrays.sort(a);
        int i=0,j=a.length-1;
        int res =-1;
        while (i<j){
            if(a[i]+a[j]>=k){
                j--;
            }else {
                res = Math.max(res,a[i+a[j]]);
                i++;
            }

        }
        return res;
    }



    public  static void main(String[] arg){
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] b = dailyTemperatures(a);
        for(int x:b){
            System.out.println(x);
        }


    }
}
