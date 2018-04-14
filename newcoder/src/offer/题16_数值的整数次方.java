package offer;

/**
 * Created by Gracecoder on 2017/12/15.
 */
public class 题16_数值的整数次方 {
    public static double Power(double base, int exponent) {

        if (base == 0 || base == 1)
            return base;

        if (exponent < 0)
            return Power(1/base,-exponent);
        else if (exponent == 0)
            return 1;
        else if ((exponent & 1) == 0)                                   //位运算的优先级 比 == 低
            return Power(base*base,exponent>>1);        //用位运算替代除法
        else
            return base*Power(base,exponent-1);

    }



    public static void main(String[] args){

        System.out.println(Power(0,0));

    }
}
