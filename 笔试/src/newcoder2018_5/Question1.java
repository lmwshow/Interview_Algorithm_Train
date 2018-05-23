package newcoder2018_5;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 19:33
 * @Description
 */
public class Question1 {

    public static void main(String[] args){


        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int f = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();

        System.out.println(x);

        int ans = 0;
        if (d >= x)
        {
            if (x * f > d)
                ans = d/x;
            else {
                ans = f + (d-x*f)/(x+p);
            }
        }

        System.out.println(ans);

    }
}
