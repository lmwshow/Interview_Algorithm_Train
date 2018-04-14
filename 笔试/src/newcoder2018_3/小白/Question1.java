package newcoder2018_3.小白;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Question1 {

    static double e = 2.71828182845904523536;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int a=0,b=0,c=0;
        double ans = 0;
        while (T-- > 0)
        {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            
            
            ans = Math.pow(e,a)*b;

            StringBuilder sb = new StringBuilder("%.");
            sb.append(c);
            sb.append("f");



//            ans = Math.floor(ans*Math.pow(10,c)+0.5)/Math.pow(10,c);

            System.out.printf(sb.toString(),ans);
            System.out.println();
            



        }

    }

}
