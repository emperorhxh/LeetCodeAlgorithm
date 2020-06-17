package com.xhx.common.algorithm.num;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 从整数数组中查找最小的k个数
 */
public class TopKNumber {


    /**
     * 用堆实现
     * @param arr
     * @return
     */
    public static int[] getLeastNumbersV1(int[] arr ,int k){

        if(k==0) return new int[0];
        if(arr.length<=k) return arr;
        Queue<Integer> head =new PriorityQueue<>(k,(l1,l2)->Integer.compare(l2,l1));
        for (int a:arr){
            if(head.isEmpty() || head.size()<k || a<head.peek()){
                head.offer(a);

            }
            if(head.size()>k){
                head.poll();
            }
        }

        int[] res = new int[k];
        int j=0;
        while (!head.isEmpty()){
            res[j++]=head.poll();
        }
        return res;
    }

    /**
     * 用快速排序的思想实现
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbersV2(int[] arr ,int k){

        if(k==0) return new int[0];
        if(arr.length<=k) return arr;
        partitionArray(arr,0,arr.length-1,k);
        int[] res=new int[k];
        for (int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }

    public static void partitionArray(int[] arr ,int begin ,int end,int k){
        int m = partition(arr,begin,end);
        if(m==k){
            return;
        }else if(m >k){
            partitionArray(arr,begin,m-1,k);
        }else {
            partitionArray(arr,m+1,end,k-m);
        }
    }
    public static int partition(int[] arr ,int low ,int high){

        int i=low;
        int j=high+1;
        int v = arr[low];
        while (true){
            while (arr[++i] < v ){
                if (i == high) {
                    break;
                }
            }
            while (arr[--j] >v){
                if (j == low) {
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int[] arr ,int a1 ,int a2){
        int temp=arr[a1];
        arr[a1]=arr[a2];
        arr[a2]=temp;
    }
    public static void main(String[] args) {
        int[] a1={3,2,1};
        int[] a2=getLeastNumbersV2(a1,2);
        for (int e:a2){
            System.out.println(e);
        }
    }
}
