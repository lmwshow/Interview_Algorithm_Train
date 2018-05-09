package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/9 08:36
 * @Description: https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 矩形覆盖 {

    public int RectCover(int target) {

        if (target < 2)
            return target;

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[target];
    }
}
