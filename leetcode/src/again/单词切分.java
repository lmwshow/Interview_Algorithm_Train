package again;

import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/10 20:21
 * @Description:
 */
public class 单词切分 {

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
