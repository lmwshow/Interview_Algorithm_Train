package 头条;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/12 10:22
 * @Description:
 */
public class 合并 {

    static class Interval {


        public int start;
        public int end;
        public Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }
    }


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


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(in.readLine());

        List<Interval> intervals = new ArrayList<>();

        String[] parts = null;
        String[] intervalstrs = null;

        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(";");
            for (int j = 0 ; j < parts.length ; j++)
            {
                String str = parts[j];
                intervalstrs = str.split(",");
                intervals.add(new Interval(Integer.parseInt(intervalstrs[0]),Integer.parseInt(intervalstrs[1])));
            }
        }

        List<Interval> list = merge(intervals);

        boolean first = true;
        for (Interval interval : list)
        {
            if (!first)
                System.out.print(";");
            System.out.print(interval.start + "," + interval.end);
            first = false;
        }
    }
}
