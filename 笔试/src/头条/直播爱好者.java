package 头条;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @Auther: minGW
 * @Date: 2018/8/12 11:13
 * @Description:
 */


public class 直播爱好者 {


    static class Interval {


        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int M = Integer.parseInt(in.readLine());

        String[] parts = in.readLine().split(" ");
        List<Interval> intervals = new ArrayList<>();

        ArrayList<Interval> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = Integer.parseInt(parts[i * 2]);
            int end = Integer.parseInt(parts[i * 2 + 1]);
            if (end < start)
                end += M;

            intervals.add(new Interval(start, end));
        }


        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });


        for (int i = 0; i < N; i++) {

            if (i == 0 || ans.get(ans.size()-1).end <= intervals.get(i).start) {
                if (intervals.get(i).end >= M) {
                    intervals.get(i).end -= M;
                    if (intervals.get(i).end <= ans.get(0).start) {
                        ans.add(intervals.get(i));
                        break;
                    }
                } else
                    ans.add(intervals.get(i));
            }

        }
        System.out.println(ans.size());
    }
}



