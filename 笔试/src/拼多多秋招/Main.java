package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/8/30 19:22
 * @Description:
 */
public class Main {

    static int n;
    static int l;
    static Map<String,Integer> map;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        l = Integer.parseInt(parts[1]);

        String[] words = new String[n];
        map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            words[i] = in.readLine();
            map.put(words[i],1);
        }



        List<String> list = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        flag = false;
        dfs(words,list,0,cur);

        if (list.size() == 0)
            System.out.println("-");
        else {
            Collections.sort(list);
            System.out.println(list.get(0));
        }

    }

    private static void dfs(String[] words, List<String> list, int index,StringBuilder cur) {

        if (index == l)
        {
            if (!map.containsKey(cur.toString())) {
                list.add(cur.toString());
                flag = true;
            }
            return;
        }

        List<Character> tmp = new ArrayList<>();

        for (int j = 0 ; j < n ; j++)
            tmp.add(words[j].charAt(index));

        Collections.sort(tmp);

        for (int i = 0 ; i < tmp.size() ; i++)
        {
            if (!flag) {
                cur.append(tmp.get(i));
                dfs(words, list, index + 1, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
