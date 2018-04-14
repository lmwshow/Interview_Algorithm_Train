package newcoder2018_3;

import java.util.*;

public class 幸运数字1 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.next();

        Map<String, Integer> map = new HashMap<>();

        int curnum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isLuckyNum(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);

                    curnum = Math.max(curnum, map.get(sub));
                }
            }
        }

        List<String> ans = new ArrayList<>();

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == curnum)
                ans.add((String) entry.getKey());
        }

        Collections.sort(ans);

        if (ans.size() == 0)
            System.out.println(-1);
        else
            System.out.println(ans.get(0));


    }

    private static boolean isLuckyNum(String sub) {

        for (int i = 0; i < sub.length(); i++)
            if (sub.charAt(i) != '4' && sub.charAt(i) != '7')
                return false;
        return true;
    }
}
