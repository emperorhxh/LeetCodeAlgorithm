package com.xhx.common.algorithm.array;// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18));

        List<Interval> res=merge(intervals);
        for (Interval interval:res){
            System.out.println(interval.start+","+interval.end);
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        if(null == intervals||intervals.size()==0) return res;
        Interval[] newArray=intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(newArray, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start) return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });

        for (int i=0;i<newArray.length;i++){
            int start = newArray[i].start;
            while (i<newArray.length-1 && newArray[i].end >= newArray[i+1].start){
                i++;
            }
            int end=newArray[i].end;
            res.add(new Interval(start,end));
        }
        return res;
    }

    static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
