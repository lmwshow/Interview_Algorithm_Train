package Top_Interview_Questions_2.again;

public class Question7_颠倒整数 {
    public static int reverse(int x) {

        boolean isNegative = false;

        if (x < 0)
        {
            isNegative = true;
            x = -x;
        }

        int res = 0;
        int base = 10;
        //越界考虑
        while (x > 0)
        {
            if (Integer.MAX_VALUE/10 < res)
                return 0;
            res = res * base + (x %10);
            x = x/10;

        }

        if (isNegative)
            return -res;
        return res;
    }

    public static void main(String[] args){


        System.out.println(reverse(-1238812));


    }
}
