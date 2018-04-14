package dp;

import java.util.*;

/**
 * Created by Gracecoder on 2017/5/6.
 */
public class leetcode140_拆词2 {

    /*
    这里需要列出所有的解，如果单纯的用DFS 会超时
    这里用 dp+dfs
    dp的作用用于记录当前状态，而不用重复去遍历
     */

    public static List<String> mywordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();
        String[] dict = (String[]) wordDict.toArray(new String[wordDict.size()]);


        String tmp = "";
        String curr = "";

        myDFS(result,s,tmp,curr,dict);

        return result;
    }

    private static void myDFS(List<String> result, String s, String tmp, String curr, String[] dict) {

        if (!s.startsWith(tmp))                         //开头错了 ， 直接剪枝
            return;
        if (s.equals(tmp))
        {
            result.add(new String(curr.substring(0,curr.length()-1)));
            return;
        }

        for (int i = 0;i < dict.length ; i++)
        {

            myDFS(result,s,tmp + dict[i] , curr + dict[i] +" ",dict);

        }
    }


    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {

        //可以减少对重复组合的遍历
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args){

        double a = 1.1;

        List<String> result = mywordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));

        Iterator iterator = result.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());

        }

    }


}
