package offer;

public class 矩形覆盖 {

    public int RectCover(int target) {

        if (target == 0 || target ==1)
            return target;

        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i < dp.length ; i++)
            dp[i] = dp[i-1]+dp[i-2];

        return dp[target];
    }

}
