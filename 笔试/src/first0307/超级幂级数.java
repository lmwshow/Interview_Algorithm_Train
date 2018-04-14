package first0307;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/3/9.
 * 暴力
 */
public class 超级幂级数 {


    public static boolean isPrime(int n)
    {
        if (n%2 == 0 &&n!=2)
            return false;
        for (int i = 3 ; i < Math.sqrt(n) ; i=i+2)
            if (n%i == 0)
                return false;

        return true;
    }

    public static void isPower(long n)
    {
        int p=0,q=0;
        double x;
        boolean flag = false;
        for (int i = 2 ; i <n ; i ++)
        {
            x = 1.0/i;
            double x1 = Math.pow(n,x);
            double x2 = Math.floor(x1);
            if (Math.pow(n,x) - Math.floor(Math.pow(n,x)) == 0&&isPrime((int)Math.pow(n,x))) {
                p = (int) Math.pow(n, x);
//                System.out.println(p + " " + q);
                q = i;
                flag = true;
            }
            if (Math.floor(Math.pow(n,x)) < 2)
                break;
        }

        if (flag)
            System.out.println(p + " " + q);
        else
            System.out.println("No");

        return;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        isPower(n);
    }
}
