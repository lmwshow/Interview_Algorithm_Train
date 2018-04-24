package Top_Interview_Questions_2.dp;

import java.util.Arrays;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/4/24 08:10
 * @Description:
 */
public class Question322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;

        Arrays.sort(coins);

//        int n = coins[coins.length - 1] > amount ? coins[coins.length - 1] : amount;
        int[] dp = new int[amount+1];

        for (int i = 1; i <= amount ;i ++)
            dp[i] = -1;

        for (int i = 0 ; i < coins.length ; i++) {
            if (coins[i] > amount)
                break;
            dp[coins[i]] = 1;
        }

        int cur = 0;
        for (int i = 1 ; i <= amount ; i++)
        {
            cur = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length ; j++)
            {
                if (i - coins[j] < 0)
                    break;
                if (dp[i-coins[j]] == -1)
                    continue;

                cur = Math.min(dp[i-coins[j]],cur);
            }

            if (cur == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = cur + 1;
        }


        return dp[amount];
    }
}
