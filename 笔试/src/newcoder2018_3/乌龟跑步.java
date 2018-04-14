package newcoder2018_3;

import java.util.Scanner;


//思维动态规划，和上次走迷宫，转向有代价的类似

//  方程定义: dp[i][j][k][d]  表示在第i个字符时候，转动j次，能否到达k位置，d表示当前方向：0表示左 1表示右

public class 乌龟跑步 {


    static int[][][][] dp = new int[110][55][220][2];

    public static void main(String[] args){

        Scanner in  = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(" ").append(in.next());

        int n = in.nextInt();

        //因为方向有左右，这里需要设置偏移量， 我们假设起点在101的位置，这样最左可以到达k=1的位置，k=0用来防止越界

        dp[0][0][101][1] = 1;


        //每次遍历对第i个字符，遍历它转0~n次的情况下，在k[0:200] 能够到达的位置
        //所以在计算第i个字符转第j次时， dp[i][j][k][0] = dp[i][j][k][0] | dp[i-1][j-1][k][1]  与 第i-1个字符在转动j-1次时能否到达k点

        for (int i = 1 ; i < sb.length() ; i++)
            for (int j = 0 ; j <= n ; j++)
                for (int k = 1 ; k <= 202 ;++k)
                    {
                        if (sb.charAt(i) == 'F')
                        {

                            if (j > 0) {
                                dp[i][j][k][0] = dp[i][j][k][0] | dp[i-1][j-1][k][1];     //F变为T，转向
                                dp[i][j][k][1] = dp[i][j][k][1] | dp[i-1][j-1][k][0];
                            }

                            // 不改变当前'F'，继续前进
                            dp[i][j][k+1][1] |= dp[i-1][j][k][1];
                            dp[i][j][k-1][0] |= dp[i-1][j][k][0];

//                            dp[i][j][k+1][1]|=dp[i-1][j][k][1];//前进
//                            dp[i][j][k-1][0]|=dp[i-1][j][k][0];//后退
//                            if (j>=2) dp[i][j][k+1][1]|=dp[i-1][j-2][k][1];//反转俩次不变，然后前进
//                            if (j>=2) dp[i][j][k-1][0]|=dp[i-1][j-2][k][0];//后退
                        }
                        else {//和前面的差不多
                            if (j > 0) {
                                dp[i][j][k+1][1] |= dp[i - 1][j - 1][k][1];
                                dp[i][j][k-1][0] |= dp[i - 1][j - 1][k][0];
                            }
                            // 不改变当前'T'，改变朝向
                            dp[i][j][k][1] |= dp[i-1][j][k][0];
                            dp[i][j][k][0] |= dp[i-1][j][k][1];
//                            if (j>=2) dp[i][j][k][1]|=dp[i-1][j-2][k][0];
//                            if (j>=2) dp[i][j][k][0]|=dp[i-1][j-2][k][1];
                        }

                    }
        int ans=0;
        for (int i=0;i<=200;i++) {
            if (dp[sb.length()-1][n][i][1] == 1) ans=Math.max(ans,(int) Math.abs(101-i));
            if (dp[sb.length()-1][n][i][0] == 1) ans=Math.max(ans,(int) Math.abs(101-i));
        }

        System.out.println(ans);




    }
}
