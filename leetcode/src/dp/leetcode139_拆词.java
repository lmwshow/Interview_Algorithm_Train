package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gracecoder on 2017/5/2.
 */
public class leetcode139_拆词 {

    /*
     基本类型无法引用传递，所以只能自己封装自定义类
     但是用DFS会超时
     */
    public static boolean mywordBreak(String s, List<String> wordDict) {


        String[] strs = (String[]) wordDict.toArray(new String[wordDict.size()]);
        int[] visit = new int[strs.length];
        Boolean[] result = new Boolean[]{false};
        String tmpStr = "";
        DFS(tmpStr,s,strs,visit,result);
        return result[0];
    }

    private static void DFS(String tmpStr, String s, String[] strs,int[] visit, Boolean[] result) {

        if (!s.startsWith(tmpStr))
            return;
        if (s.equals(tmpStr))
        {
            result[0] = true;
            return;
        }
        if (tmpStr.length() >= s.length())
            return;

        for (int i = 0 ; i < strs.length ; i++)
        {
            DFS(tmpStr+strs[i],s,strs,visit,result);            //String 类型DFS递归 不需要add 和 romove当前节点，因为都是值传递

            if(result[0] == true)
                return;
        }


    }

    /*
    动态规划
    dp[i]表示长度为i的字符串能否切分
    动态转移方程：dp[j] = dp[i] && s[i,j) in dict

     */

    public static boolean wordBreak(String s, List<String> wordDict) {

        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;

        for (int i = 0 ; i <= length;i ++)
            for (int j = i+1; j <= length ; j++)
            {
                if (dp[j] == false)
                dp[j] = dp[i] && wordDict.contains(s.substring(i,j));
            }

        return dp[length];


    }



    public static void main(String[] args){

        double a = 1.1;

        Boolean result = wordBreak("leetcode",Arrays.asList("leet","code"));

        System.out.println(result);


    }

}
