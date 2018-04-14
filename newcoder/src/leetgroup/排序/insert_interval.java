package leetgroup.排序;




import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/8/22.
 * http://blog.csdn.net/linhuanmars/article/details/22238433
 *
 * 这道题跟Merge Intervals很类似
 */

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class insert_interval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res = new ArrayList<>();

        if (intervals.isEmpty())
        {
            res.add(newInterval);
            return res;
        }

        int i = 0;
        //首先把原list中 元素end 小于 newInterval.start 的按原来顺序插入到新的结果集
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
        {
            res.add(intervals.get(i));
            i++;
        }

        //接下来进入插入阶段，如果当前区间和新区间发生重合，则start取两者最小的start，end取两者最大的end，生成一个新的区间
        //注意一点是，我们不知道重合区域，跨越了后面多少个区域


        //先处理newInterval 的start,加入结果集，然后根据遍历后面的区域，改变end
        if (i < intervals.size())
            newInterval.start = Math.min(intervals.get(i).start,newInterval.start);


        res.add(newInterval);

        //开始处理后面end，重合的区域。当前i的start如果大于newInterval.end，那么newInterval.end就不需要变，直接跳出
        //完美处理了各种情况
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end)
        {
            newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }

        while (i < intervals.size())
        {
            res.add(intervals.get(i));
            i++;
        }

        return res;

    }
}
