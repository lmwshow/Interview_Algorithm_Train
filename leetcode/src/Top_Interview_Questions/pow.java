package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/10/5.
 *
 * 一个for循环O（n） 大数据超时，说明需要优化
 *
 * 那就想想O(logN)的方法,二分法
 *
 * 这道题是一道数值计算的题目，因为指数是可以使结果变大的运算，所以要注意越界的问题。
 *
 */
public class pow {

    public static double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n < 0)
        {

            //判断数值越界，Integer.MIN_VALUE 可以表示到-2147483648，而最大值只能2147483647
            if (x >= 1/Double.MAX_VALUE || x <= -1/Double.MAX_VALUE)
                x = 1/x;
            else
                return Double.MAX_VALUE;

            if (n == Integer.MIN_VALUE)
            {
                n++;
                return x*myPow(x,-n);
            }

            n = -n;

        }


//        for (int i = 0; i < n; i++)
//            res *= x;

        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);

    }
    
    public static void main(String[] args){
        
        System.out.println(myPow(34.00515
                ,-3));

        System.out.println(Double.MIN_VALUE);

        
    }
}

