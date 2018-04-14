package Top_Interview_Questions_2.again;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question139_单词拆分 {

    static boolean ans;

    //题目链接：https://leetcode.com/problems/word-break
    //普通DFS超时，时间复杂度超出O(n^2)
    public boolean BaoliwordBreak(String s, List<String> wordDict) {

        ans = false;

        int len = wordDict.size();


        StringBuilder sb = new StringBuilder("");
        dfs(sb, s, wordDict);

        return ans;
    }

    private void dfs(StringBuilder sb, String s, List<String> wordDict) {

        if (sb.length() > s.length())
            return;

        if (sb.length() == s.length() && sb.toString().equals(s)) {
            ans = true;
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (wordDict.get(i).length() + sb.length() > s.length())
                continue;
            sb.append(wordDict.get(i));
            dfs(sb, s, wordDict);
            sb.delete(sb.length() - wordDict.get(i).length(), sb.length());
        }

    }

    //利用DFS+缓存记忆，记录所有在当前index时，后面无法组成单次的下标位置，将DFS降至O(n^2)
    public boolean MemwordBreak(String s, List<String> wordDict) {


        Set<Integer> set = new HashSet<>();

        return memDfs(s, 0, set, wordDict);

    }

    private boolean memDfs(String s, int index, Set<Integer> set, List<String> wordDict) {

        //base case
        if (index == s.length())
            return true;
        // check memory
        if (set.contains(index))
            return false;

        for (int i = index + 1; i < s.length(); i++) {
            String t = s.substring(index, i);
            if (wordDict.contains(t)) {
                if (memDfs(s, i, set, wordDict))
                    return true;
                else
                    set.add(i);
            }
        }

        set.add(index);
        return false;
    }


    //既然需要利用缓存记忆，那就很容易想到使用DP来求解
    //定义状态方程: dp[i] 表示s(0,i-1)是否能通过wordDict组成
    //            dp[i+1] = dp[j]&&wordDict.contains(s.substring(j,i)),for(j=1...i)
    public boolean wordBreak(String s, List<String> wordDict) {


        boolean[] ans = new boolean[s.length() + 1];
        ans[0] = true;

        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (ans[j] && wordDict.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }


        return ans[s.length()];
    }

}
