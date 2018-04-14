package dp;

import java.util.List;

/**
 * Created by Gracecoder on 2017/3/3.
 */
public class leetcode120 {

    //定义子问题： dp[i][j]表示到达map[i][j]这点的最短路劲
    //动态转移方程: dp[i][j] = min(dp[i-1][j],dp[i-1][j-1]) + map[i][j]        因为(i,j)向下 只能到两个位置 (i+1,j)或者(i+1,j+1)
    //自顶向下： O（n^2） space&time
    public int minimumTotal(List<List<Integer>> triangle) {

        int length = triangle.size();
        if (length < 1)
            return 0;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1 ; i < length ; i ++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }

        for (int i = 1; i < length; i ++)
            for (int j = 1 ; j < i ; j++)                       //每一行的第一个元素 和最后一个元素 ，不能按这个动态转移方程来，会越界。
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
            }

        int min = dp[length-1][0];
        for (int i = 1 ; i < length; i ++)
            min = dp[length-1][i] < min ? dp[length-1][i]:min;

        return min;
    }


    //自底向上： O（n） space
    public int betterSolution(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (length < 1)
            return 0;
        if (length == 1)
            return triangle.get(0).get(0);
        int[] dp = new int[length];

        for (int i = 0; i < length; i++)
            dp[i] = triangle.get(length - 1).get(i);

//        for (int i = length - 2; i >=0 ; i --) {
//            for (int j = i; j >= 0; j--)
//                dp[j + 1] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
//
//            //之所以覆盖dp[j+1] 是因为 dp[j] 在下一次循环还有用而dp[i+1]已经没用了, 画图很容易看明白
//            //经过上步的操作dp[0] 其实是第i行的数据， 在进入第i-1行前， 将dp数组都向前移动一位，使得满足规律
//            for (int k = 0 ;k < length -1 ; k ++)
//                dp[k] = dp[k+1];
//            }

        for (int i = length - 2; i >= 0 ; i --)
            for (int j = 0 ; j <= i ; j ++)
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);


        return dp[0];

    }
}
