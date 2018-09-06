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
public class Question8 {
    
    static int n;
    static int l;
    static Map<String,Integer> map;
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
            if (!map.containsKey(cur.toString()) && !list.contains(cur.toString()))
                list.add(cur.toString());
            return;
        }
        
        for (int j = 0 ; j < n ; j++)
        {
            cur.append(words[j].charAt(index));
            dfs(words,list,index + 1,cur);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
