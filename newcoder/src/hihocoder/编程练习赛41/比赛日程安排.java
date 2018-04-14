package hihocoder.编程练习赛41;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class 比赛日程安排 {

    static int[] cal = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static List<String> preAndnextDay(String curDay) {

        //放前一天 和 后一天
        List<String> res = new ArrayList<>();
        String[] list = curDay.split("-");
        int month = (list[0].charAt(0) - '0') * 10 + list[0].charAt(1) - '0';
        int day = (list[1].charAt(0) - '0') * 10 + list[1].charAt(1) - '0';

        StringBuilder sb = new StringBuilder(list[0]);
        sb.append('-');
        StringBuilder sb1 = new StringBuilder(sb.toString());

        int premonth = month - 1;
        int nextmoth = month + 1;
        int preday = day - 1;
        int nextday = day + 1;

        if (preday < 10)
            sb1.append('0');
        sb1.append(Integer.toString(preday));

        if (nextday < 10)
            sb.append('0');
        sb.append(Integer.toString(nextday));

        if (day < cal[month] && day > 1) {

            res.add(new String(sb1));
            res.add(new String(sb));

        }
        if (day == cal[month]) {
            sb.delete(0, sb.length());
            if (nextmoth < 10)
                sb.append('0');
            sb.append(Integer.toString(nextmoth));
            sb.append('-');
            nextday = 1;
            sb.append(Integer.toString(nextday));

            res.add(new String(sb1));
            res.add(new String(sb));
        }
        if (day == 1) {
            sb1.delete(0, sb1.length());
            if (premonth < 10)
                sb1.append('0');
            sb1.append(Integer.toString(premonth));
            sb1.append('-');
            preday = cal[premonth];
            sb1.append(Integer.toString(preday));


            res.add(new String(sb1));
            res.add(new String(sb));
        }


        return res;


    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n, m;
        String c;
        Map<String, List<String>> map = new HashMap<>();
        List<String> gameList = new ArrayList<>();


        while (t-- > 0) {

            n = in.nextInt();
            m = in.nextInt();
            c = in.nextLine();
            gameList.clear();
            while (n-- > 0)
                gameList.add(in.nextLine());

            boolean falg = true;
            for (String curday : gameList) {
                String[] list = curday.split(" ");

                List<String> preandnextday = preAndnextDay(list[0]);
                List<String> preList = map.getOrDefault(preandnextday.get(0), null);
                List<String> nextList = map.getOrDefault(preandnextday.get(1), null);
                List<String> curList = map.getOrDefault(list[0], null);

                if (curList != null && (curList.contains(list[1]) || curList.contains(list[2]))) {
                    falg = false;
                    break;
                }
                if (preList != null && (preList.contains(list[1]) || preList.contains(list[2]))) {
                    falg = false;
                    break;
                }
                if (nextList != null && (nextList.contains(list[1]) || nextList.contains(list[2]))) {
                    falg = false;
                    break;
                }

                if (curList == null)
                    curList  = new ArrayList<String>();
                curList.add(list[1]);
                curList.add(list[2]);

                map.put(list[0],curList);

            }

            if (falg)
                System.out.println("YES");
            else
                System.out.println("NO");

        }

        return;
    }
}
