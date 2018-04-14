package leetgroup.排序;

import java.util.*;

/**
 * Created by Gracecoder on 2017/8/17.
 */



class MyComparator implements Comparator<Interval>
{

    @Override
    public int compare(Interval o1, Interval o2) {

        if (o1.start>o2.start)
            return 1;
        else if (o1.start == o2.start)
            return 0;
        else
            return -1;
    }

}

public class merge_intervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();

        Collections.sort(intervals,new MyComparator());


        Iterator iterator = intervals.iterator();
        while (iterator.hasNext())
        {
            Interval cur = (Interval) iterator.next();


            if (res.size() > 0)
            {
                Interval last = res.get(res.size() - 1);

                if (cur.end <= last.end)
                    continue;
                else if(cur.start <= last.end)
                    last.end = cur.end;
                else
                    res.add(cur);
            }
            else
            {
                res.add(cur);
            }
        }
        return res;

    }
    
    
    public static void main(String[] args){

        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(2,6));
        list.add(new Interval(1,7));

        Collections.sort(list,new MyComparator());

        System.out.println("");

    }

}
