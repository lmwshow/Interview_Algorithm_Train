/**
 * Created by Gracecoder on 2017/10/2.
 */
public class reverse_integer {

    public static int reverse(int x) {

        int flag = 0;
        int res = 0;

        if (x < 0) {
            x = -x;
            flag = 1;
        }


        while (x > 0)
        {
            if (Integer.MAX_VALUE /10 <= (res - x%10))
                return 0;
            res = res*10 + x%10;
            x = x/10;
        }

        if (flag == 1)
            res = -res;

        return res;
    }


    public static void main(String[] args){


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


        System.out.println(reverse(1563847412));


    }
}
