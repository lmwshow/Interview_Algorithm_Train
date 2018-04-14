package newcoder2018_3.小白;

import java.util.Scanner;

public class Question3 {


    public static void main(String[] args){


        Scanner in = new Scanner(System.in);


        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long mod = in.nextLong();

        a = a%mod;
        b = b%mod;
        c = c%mod;
        d = d%mod;

        long x = (a*b)%mod;
        x = (x*c)%mod;

        long ans = 1;
        for (int i = 1 ; i <= d ;i++)
            ans = (ans*x)%mod;

        System.out.println(ans);


    }
}
