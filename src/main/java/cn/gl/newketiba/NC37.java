package cn.gl.newketiba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * NC37 合并区间
 */
public class NC37 {

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        List<ComparableInterval> comparableIntervalList = sortInterval(intervals);
        LinkedList<ComparableInterval> sortedIntervals = new LinkedList(comparableIntervalList);
        Interval first = sortedIntervals.removeFirst();
        while (!sortedIntervals.isEmpty()) {
            Interval other = sortedIntervals.getFirst();
            if (first.end >= other.start) {
                sortedIntervals.removeFirst();
                // merge interval 
                int end = first.end > other.end ? first.end : other.end;
                Interval temp = new Interval(first.start, end);
//                 temp.start = first.start;
//                 temp.end = other.end;
                first = temp;
            } else {
                result.add(first);
                first = sortedIntervals.removeFirst();
            }
        }
        result.add(first);
        return result;
    }

    private List<ComparableInterval> sortInterval(ArrayList<Interval> intervals) {
        List<ComparableInterval> comparableIntervalList = new ArrayList<>();
        for (Interval interval : intervals) {
            ComparableInterval comparableInterval = new ComparableInterval(interval.start, interval.end);
//             comparableInterval.start = interval.start;
//             comparableInterval.end = interval.end;
            comparableIntervalList.add(comparableInterval);
        }
        Collections.sort(comparableIntervalList);
        return comparableIntervalList;
    }

    static class ComparableInterval extends Interval implements Comparable {

        public ComparableInterval(int start, int end) {
            super(start, end);
        }

        public int compareTo(Object o) {
            Interval anatherInterval = (Interval) o;
            if (super.start > anatherInterval.start) {
                return 1;
            } else if (this.start < anatherInterval.start) {
                return -1;
            } else if (this.end > anatherInterval.end) {
                return 1;
            } else if (this.end < anatherInterval.end) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
    
