package leetgroup;

/**
 * Created by Gracecoder on 2017/5/18.
 * 输入两个整数，dividend, divisor，不要使用乘法，除法，取模运算，求出a/b的值。
 *
 * -2147483648 为 2的31次 对它取- 仍然是 -2147483648.  然而 -2147483648 - 1 = 2147483647
 * 需要使用long 防止int溢出
 *   对于int类型的范围是 [- 2^31~2^31 -1] 即[-2147483648,2147483647] 超过最大范围就用最大范围表示，补码计算 ，因为第一位用于表示符号位 -0的补码用来表示 -最小值，所有使得能多表示一位最小值

 */
public class divide_two_integers {

    public static int divide(int dividend, int divisor) {

        long res = 0;
        int flag = 0;           //0正1负
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))
            flag = 0;
        else
            flag = 1;

        long long_divident = dividend;
        long long_divisor = divisor;

        long_divident = long_divident < 0 ? -long_divident : long_divident;
        long_divisor = long_divisor < 0 ? -long_divisor : long_divisor;

        int power = 1;
        long tmpdivisor = long_divisor;
        while (true) {

            if (long_divident < long_divisor) {
                break;
            }

            if (long_divident < tmpdivisor)
            {
                tmpdivisor = long_divisor;
                power = 1;
            }
//
//            while (long_divident < tmpdivisor) {
//                tmpdivisor = tmpdivisor >> 1;
//                power = power >> 1;
//            }


            res += power;
            long_divident -= tmpdivisor;
            tmpdivisor = tmpdivisor << 1;
            power = power << 1;


        }
        if (flag == 1)
            res = -res;
        return (int)(res>Integer.MAX_VALUE?Integer.MAX_VALUE:res);
        //对于int类型的范围是 [- 2^31~2^31 -1]  超过最大范围就用最大范围表示，补码计算 ，因为第一位用于表示符号位 -0的补码用来表示 -最小值，所有使得能多表示一位最小值

    }


    public static void main(String[] args) {


        long x = -2147483648;
        System.out.println(x-1);

        x <<= 1;
        System.out.println(divide(-2147483648, -1));

    }
}
