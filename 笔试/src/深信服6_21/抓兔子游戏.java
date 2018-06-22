package 深信服6_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 20:08
 * @Description:
 */
public class 抓兔子游戏 {

    static int maxn = 8005;
    static boolean[][] dp = new boolean[maxn][maxn];
    static int[] a = new int[maxn];

    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = in.readLine().split(" ");
        for(int i=1; i<=k; i++)a[i]=Integer.parseInt(parts[i-1]);
        for(int i=1; i<=n; i++){
            if(i!=a[1]) dp[1][i]=true;
            else dp[1][i]=false;
        }
        for(int i=2; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(j>1)dp[i][j]|=dp[i-1][j-1];
                if(j<n)dp[i][j]|=dp[i-1][j+1];
                if(j==a[i])dp[i][j]=false;
            }
        }
        boolean ans=false;
        for(int i=1; i<=n; i++)ans|=dp[k][i];
        if(ans)
            System.out.println("No\n");
        else
            System.out.println("Yes\n");

    }


}



