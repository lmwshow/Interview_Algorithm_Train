package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/9 08:27
 * @Description: https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 跳台阶 {

    public int JumpFloor(int target) {

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
