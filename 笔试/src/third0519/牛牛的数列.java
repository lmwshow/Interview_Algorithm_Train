package third0519;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/5/25.
 *
 * 正着枚举记录一下当前位置的连续上升子序列长度,倒着也做一遍。
    最后枚举一个连接点即可。
 */
public class 牛牛的数列 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int[] A = new int[n+2];
        A[0] = A[n+1] = Integer.MIN_VALUE;
        int max = 0;

        for (int i = 1 ;i <= n;i++)
            A[i] = in.nextInt();

        int[] pre = new int[n+2];               //正序
        int[] suf = new int[n+2];               //逆序

        for (int i = 1; i <=n ;i++)
            pre[i] = A[i-1]<A[i]?pre[i-1]+1:1;

        for (int i = n; i >=1 ; i--)
            suf[i] = A[i]<A[i+1]?suf[i+1]+1:1;

        //这样就有两个数组，表示正序和逆序，pre[i],suf[i]表示以i为结尾的严格递增的长度
        //然后遍历连接点，如果满足连接条件就连接， 选出最大值

        for (int i = 1 ;i <= n; i++)
        {
            max = Math.max(max,pre[i-1]+1);                 //遍历连接点的时候，需要比较的是连接点左右相邻点的长度 再 +1 连接点
            max = Math.max(max,suf[i+1]+1);

            if (A[i+1]-A[i-1]>=2)
                max = Math.max(max,pre[i-1]+suf[i+1]+1);
        }


        System.out.println(max);


    }
}
