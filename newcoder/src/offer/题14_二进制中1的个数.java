package offer;

/**
 * Created by Gracecoder on 2017/12/15.
 *
 * 位运算的熟练使用  n&(n-1)  可以使最后一个1后面的数变为0 前面的不变
 */
public class 题14_二进制中1的个数 {

    public static int NumberOf1(int n) {

        int res = 0;
        while (n!=0)
        {
            n = n&(n-1);
            res++;
        }

        System.out.println(res);

        return res;
    }

    public static void main(String[] args){


        NumberOf1(29);
    }

}
