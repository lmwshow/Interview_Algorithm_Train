package hihocoder.编程练习赛57;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/2 11:32
 * @Description: http://hihocoder.com/problemset/problem/1733
 *
 * 给定N个数组，每个数组都包含M个整数。

 * 现在你被要求从每个数组中选出一个数，总共N个数。

 * 在M^N种选法中，有多少种选法满足选出的N个数恰好是严格递增的？

 * 样例中有5种选法：{1, 3, 4}, {1, 3, 9}, {1, 5, 9}, {1, 7, 9}, {6, 7, 9}
 *
 *
 * 动态规划 dp[i][j] 表示第i层，选中第j个时，递增N元组的个数
 *         dp[i][j] = 上一层小于num[i][j]的元素被选中时递增N元组的累加和
 *
 *         所以需要二分查找上一层小于num[i][j]数中的最大数
 */
public class Q2_递增N元组 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][]a=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)a[i][j]=sc.nextInt();
            Arrays.sort(a[i]);
        }


        long[][]dp=new long[n][m];
        Arrays.fill(dp[0], 1);
        for(int i=1;i<n;i++) {
            long[]sum=new long[m];                          //sum[index]用来表示上一层选中下标index时之前所有递增序列的个数
            sum[0] = dp[i-1][0];
            for(int j=1;j<m;j++) sum[j]=sum[j-1]+dp[i-1][j];

            for(int j=0;j<m;j++) {
                int t=BS(a[i-1], a[i][j]);
                if(a[i-1][t]>=a[i][j]) continue;
                dp[i][j] = sum[t];
                dp[i][j]%=1000000007;
            }
        }

        long s=0;
        for(int j=0;j<m;j++)s+=dp[n-1][j];                  //ans为 遍历最后一层累加选中每个元素时，递增序列的个数
        System.out.println(s%1000000007);
    }


    /**
     *
     * @param a
     * @param v
     * @return 二分搜索 小于v的最大下标
     */
    private static int BS(int[] a, int v) {
        int lo=0,hi=a.length-1;
        while(lo+1<hi) {
            int mid=(lo+hi)/2;
            if(a[mid]>=v) hi=mid-1;
            else lo=mid;
        }
        if(lo+1==hi && a[hi]<v) return hi;
        return lo;
    }
}
