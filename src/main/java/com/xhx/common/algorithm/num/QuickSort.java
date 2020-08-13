package com.xhx.common.algorithm.num;

/**
 * 快速排序算法
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 4, 4, 4656, 5,97,1212,342,134,9,2,6,34};
        int len = arr.length - 1;
        qsort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static void qsort(int[] a,int left,int right){
        if(a.length == 0) return;
        int key=a[left];
        int start = left;
        int end=right;
        while (left<right){
            while (left<right && a[right] > key){
                right--;
            }
            while (left<right&& a[left] <key){
                left++;
            }
            if(a[left]== a[right] && left<right){
                left++;
            }else {
                int temp=a[left];
                a[left]=a[right];
                a[right]=temp;
            }
        }
        if(left-1>start) qsort(a,start,left-1);
        if(right+1<end) qsort(a,right+1,end);
    }
}
