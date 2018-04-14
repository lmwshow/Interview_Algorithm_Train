package 真题;


import java.util.Map;
import java.util.Scanner;

//dp[i][j] 表示从1到j号学生中选i个(j必选)，相邻id 不超过k 的最大乘积
//dp[i][j] = max(num[j]*(dp[i-1][j]...dp[i-1][j-k]))
public class 合唱团 {


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n+1];

        for (int i = 1;i <= n ; i++)
            nums[i] = in.nextInt();

        int k = in.nextInt();
        int d = in.nextInt();

        //因为有正负，需要两个数组来维护 最大值 和最小值
        //要用long  已经超过int范围
        long[][] dp = new long[k+1][n+1];
        long[][] dp_min = new long[k+1][n+1];

        for (int i = 1 ; i <= n; i++) {
            dp[1][i] = nums[i];
            dp_min[1][i] = nums[i];
        }

        for (int i = 2; i <=k ; i++)
        {
            for (int j = i ; j <=n ; j++)
            {
                int start = Math.max(1,j-d);
                for (int index = start; index <j ;index++) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(nums[j] * dp[i - 1][index],nums[j] * dp_min[i - 1][index]));
                    dp_min[i][j] = Math.min(dp_min[i][j], Math.min(nums[j] * dp_min[i - 1][index],nums[j] * dp[i - 1][index]));

                }

            }


        }

        long res = dp[k][k];
        for (int i = k+1;i <=n ;i++) {
            res = Math.max(res, dp[k][i]);
        }

        System.out.println(res);




    }
}
