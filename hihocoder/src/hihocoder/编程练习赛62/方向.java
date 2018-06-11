package hihocoder.编程练习赛62;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/3 12:02
 * @Description
 */
public class 方向 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int ans = 0;

        boolean altb = false;
        if (Math.abs(a) < Math.abs(b))
            altb = true;
        else if (Math.abs(a) == Math.abs(b))
            altb = a > 0;

        a = a + 360;
        b = b + 360;

        if (altb)
        {
            int tmp1 = b-a;
            int tmp2 = 360 - tmp1;
            ans = tmp1 < tmp2 ? tmp1 : -tmp2;

        }
        else
        {
            int tmp1 = a - b;
            int tmp2 = 360 - tmp1;
            ans = tmp1 < tmp2 ? -tmp1 : tmp2;
        }



        System.out.println(ans);



    }
}
