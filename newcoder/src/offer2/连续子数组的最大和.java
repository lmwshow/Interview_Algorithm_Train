package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/14 18:28
 * @Description https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 动态规划: dp[i]表示以i为结尾的子数组最大和
 */
public class 连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0)
            return 0;


        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];

        for (int i = 1 ; i < array.length ; i++)
        {
            dp[i] = dp[i-1]>0?(dp[i-1]+array[i]):array[i];
            max = Math.max(max,dp[i]);
        }

        return max;


    }
}
