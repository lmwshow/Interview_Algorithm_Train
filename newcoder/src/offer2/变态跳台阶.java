package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/9 08:31
 * @Description: https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 变态跳台阶 {

    public int JumpFloorII(int target) {

        if (target < 2)
            return target;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++)
            for (int j = 0 ; j < i ; j++)
                dp[i]+=dp[j];

        return dp[target];

    }
}
