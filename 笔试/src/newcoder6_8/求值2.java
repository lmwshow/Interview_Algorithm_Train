package newcoder6_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/8 19:35
 * @Description:
 */
public class 求值2 {




    final static int mo=998244353;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        long n, pre=1;
        long []arr = new long[1000010];
        n=cin.nextLong();

        for(long i=2; i<=2*n; i+=2) {
            arr[(int) (i/2)]=(pre+pre)%mo;
            pre=(arr[(int)(i/2)]+arr[(int)(i/2)]*(i-i/2)%mo*inver(i/2+1))%mo;
        }

        //System.out.println(arr[1000]);
        long ans=0;
        for(int i=1; i<=n; i++)
            ans=(ans+arr[i])%mo;
        System.out.println(ans);
        cin.close();
    }

    static long inver(long tmp) {
        long n=mo-2;
        long ans=1;
        while(n>0) {

            if(n%2==1)
                ans=(tmp*ans)%mo;

            tmp=tmp*tmp%mo;
            n>>=1;
        }
        return ans;
    }
}
