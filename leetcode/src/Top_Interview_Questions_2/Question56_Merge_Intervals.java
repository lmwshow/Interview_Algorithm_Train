package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question56_Merge_Intervals {

    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> ans = new ArrayList<>();

        if (intervals == null || intervals.size() < 2)
            return intervals;

        //先对start 排序

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        ans.add(intervals.get(0));

        for (int i = 1 ; i < intervals.size() ; i++)
        {
            if (intervals.get(i).start <= ans.get(ans.size() - 1).end)
                ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end,intervals.get(i).end);
            else {
                ans.add(intervals.get(i));
            }
        }


        return ans;

    }

    public static void main(String[] args){
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        
        
        List<Interval> ans = merge(list);
        System.out.println();
        
    }
}
