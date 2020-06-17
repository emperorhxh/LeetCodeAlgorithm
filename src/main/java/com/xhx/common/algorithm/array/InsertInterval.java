package com.xhx.common.algorithm.array;// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.Arrays;
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
public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1,2),new Interval(3,5),new Interval(6,7),new Interval(8,10),new Interval(12,16));
        Interval newInterval = new Interval(4,9);
        List<Interval> res=insert(intervals,newInterval);
        for (Interval interval:res){
            System.out.println(interval.start+","+interval.end);
        }
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i=0;

        while (i<intervals.size()&&intervals.get(i).end<newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        int start= newInterval.start;
        int end= newInterval.end;
        while (i<intervals.size() && intervals.get(i).start<=newInterval.end){
            start=Math.min(start,intervals.get(i).start);
            end=Math.max(end,intervals.get(i).end);
            i++;
        }
        res.add(new Interval(start,end));
        while (i<intervals.size()){
            res.add(intervals.get(i));
            i++;
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
