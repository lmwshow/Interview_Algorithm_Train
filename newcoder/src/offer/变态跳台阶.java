package offer;

public class 变态跳台阶 {

    public static int JumpFloorII(int target) {

        if (target == 0 || target == 1)
            return target;

        int[] dp = new int[target+1];
        dp[0] = 1;dp[1] = 1; dp[2] = 2;
        for (int i = 3 ; i < dp.length ; i++)
            for (int j = 0 ; j < i ; j++)
                dp[i] += dp[j];

        return dp[target];
    }

    public static void main(String[] args){

        System.out.println(JumpFloorII(3));


    }
}
