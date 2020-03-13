package com.xhx.common.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayAlg {
    public static void main(String[] args) {
       // System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(containNearByDuplicate(new int[]{1,2,3,1,2,3},2));
        //System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    /**
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * @param arr
     * @return
     */
    private static List<Integer> majorityElementOf3(int[] arr){
        List<Integer> res = new ArrayList<>();
        if(arr.length <1)return  res;
        int a = arr[0],b=arr[0];
        int ca=0,cb=0;
        for(int num:arr){
            if(a == num){
                ca++;
                continue;
            }
            if(b == num){
                cb++;
                continue;
            }
            if(ca == 0){
                a=num;
                ca++;
                continue;
            }
            if(cb == 0){
                b =num;
                cb++;
                continue;
            }
            ca--;
            cb--;
        }
        ca=0;
        cb=0;
        for(int num:arr){
            if(num ==a){
                ca++;
            }else if(num == b){
                cb++;
            }
        }
        if(ca >arr.length/3) res.add(a);
        if(cb >arr.length/3) res.add(b);
        return res;
    }
    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * @param arr
     * @param k
     * @return
     */
    private static boolean containNearByDuplicate(int[] arr,int k){
        if(arr.length <=1)return false;
        if(k <=0 || k>arr.length-1) return false;
        for(int i=0;i<arr.length;i++){
            if(i+k <arr.length && arr[i] == arr[k+i])return true;
        }
        return false;
    }
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 **s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。**如果不存在符合条件的连续子数组，返回 0。
     * @param arr
     * @param s
     * @return
     */
    private static int minSubArray(int[] arr,int s){

        if(arr.length == 0)return 0;
        if(arr[0] >= s)return 1;
        if(arr.length == 1){
            return 0;
        }
        int left =0,right = 1;
        int sum = arr[0]+arr[1];
        int res= arr.length+1;
        while (right < arr.length){
            if(sum >=s){
                res = res < right-left+1?res:right-left+1;
                sum-=arr[left++];
            }else {
                right++;
                if(right >arr.length-1){
                    break;
                }
                sum+=arr[right];
            }
        }
        if(res == arr.length+1){
            res = 0;
        }
        return res;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * @param arr
     * @return
     */
    private static int majorityElement(int[] arr){
        int candidate =arr[0],count=1;
        for (int e:arr){
            if(count == 0){
                candidate = e;
                count=1;
            }else if(candidate == e){
                count++;
            }else {
                count--;

            }
        }
        return  candidate;

    }
    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2*。*
     * @param arr
     * @return
     */
    private static int[] towSumFixed(int[] arr,int target){

        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int e = target - arr[i];
            String key = e+"";
            if(map.containsKey(key)){
                return new int[]{map.get(key)+1,i+1};
            }else {
                map.put(arr[i]+"",i);
            }
        }

        return new int[]{};

    }
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * @param arr
     * @return
     */
    private static int maxinumGap(int[] arr){

        if(arr.length <2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n:arr){
            min = Math.min(min,n);
            max =Math.max(max,n);
        }
        int bucketSize = Math.max(1,(max - min)/(arr.length-1));

        Bucket[] buckets = new Bucket[(max-min)/bucketSize+1];
        for(int i=0;i<arr.length;i++){
            int loc = (arr[i] - min)/bucketSize;
            if(buckets[loc] == null){
                buckets[loc] = new Bucket();
                buckets[loc].max=arr[i];
                buckets[loc].min=arr[i];
            }else {
                buckets[loc].max=Math.max(arr[i],buckets[loc].max);
                buckets[loc].min=Math.min(arr[i],buckets[loc].min);
            }
        }
        int previousMax = Integer.MAX_VALUE;
        int maxGap = Integer.MIN_VALUE;

        for (int i =0;i<buckets.length;i++){
            if(buckets[i] != null && previousMax != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap,buckets[i].min-previousMax);
            }
            if(buckets[i] != null ){
                previousMax = buckets[i].max;
                //maxGap = Math.max(maxGap,buckets[i].max-buckets[i].min);
            }
        }
        return maxGap;
    }
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组  [0，1，2，4，5，6，7]  可能变为 [4，5，6，7，0，1，2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     * @param arr
     * @return
     */
    private static int findMin(int[] arr){

        int low=0,high= arr.length-1;
        while (low < high){
            if(arr[low] < arr[high]) return arr[low];
            int mid = low + (high-low)/2;
            if(arr[mid] > arr[high]){
                low = mid+1;
            }else {
                high = mid;

            }
        }

        return arr[low];
    }
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * @return
     */
    private static void sortColors(int[] arr){

        int pre = -1;
        int next = arr.length;
        for(int i=0;i< next;i++){
            if(i==1){
                i++;
            }else if(i==2){
                next--;
                swap(arr[i],arr[next]);
            }else {
                pre++;
                swap(arr[i],arr[pre]);
                i++;
            }
        }

    }
    private static void swap(int x,int y){
        int temp=x;
        x=y;
        y=temp;
    }
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * @return
     */
    private static int[] plusOne(int[] digits){

        int n = digits.length;
        //从数组末尾开始向前遍历
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                //没有进位，直接返回
                return digits;
            }
            //产生进位，需要将该位赋值为 0
            digits[i] = 0;
        }
        //整体产生了进位，数组长度需要变化加 1
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;

    }
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度.
     * @param arr
     * @return
     */
    private static int removeDuplicates(int[] arr){

        int pre=0,cur=0;
        while (cur<arr.length){
            if(arr[pre] != arr[cur]){
                pre++;
                arr[pre] = arr[cur];
            }
            cur++;
        }
        return 0;

    }
    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * @param nums
     * @return
     */
    private static int firstMissingPositive(int[] nums){
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length;) {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }

            // swap
            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数
     * 1. 1
     * 2. 11
     * 3. 21
     * 4. 1211
     * 5. 111221
     * @param n
     * @return
     */
    private static String countAndSay(int n){

        if(n == 1) return "1";
        String x = countAndSay(n-1);
        char[] arr = x.toCharArray();
        char currentChar =arr[0];
        int currentCount =1;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<arr.length;i++){
            if(arr[i]==currentChar){
                currentCount++;
            }else {
                sb.append(currentCount).append(currentChar);
                currentChar =arr[i];
                currentCount=1;
            }
        }
        sb.append(currentCount).append(currentChar);
        return sb.toString();

    }

    static class Bucket{
        private int min;
        private int max;

    }
}
