package first0307;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/3/10.
 */
public class 翻转01 {

    public static int getTimes(int A,int B,int k)
    {
        if (k > (A+B) && A!=0)
            return -1;
        if (k == A)
            return 1;
        int time = 1;
        while (true) {
            if (k <= A)
            {
                A = A-k;
                B = B+k;
                if (A==0)
                    return time;
            }
            else {
                int d = k - A;          //表示距离第n-1步， 即只剩k个0的时候，还差几个0
                int b = (k + d) / 2;        //a表示转A的数量，b 表示转B的数量， a+b=k  令 b-a =d
                boolean flag = (k + d) % 2 == 0 ? true : false;      //表示次数刚好时，而不是取整
                if (flag && B >= b)
                    return time+1;         //time 表示到达第n-1步的次数
                else {
                    b = B >= b ? b : B;      //B的个数大于b时，那就转b个，小于时，只能转B个
                    A = A + b - (k - b);
                    B = B + (k - b) - b;
                }
            }
            time++;
        }
    }

    public static int solotion(int A, int B , int k)
    {
        if (A == 0)
            return 0;
        if (k > (A+B))
            return -1;
        if (k == A)
            return 1;
        int single = A;                 //总的转次数等于， A个单转+某些位置的双转
//        int dou ;                       //dou = (x*k-A)/2
        int mx = 0;
        for (int i = 1; i <=200000; i++)
        {
//            if (k <= A)
//            {
//                A = A-k;                                      //对k<A的情况， 这里 A,B 不能跟着变，因为下面dou1，dou2是通过原始的A ,B 得到的
//                B = B+k;
//                if (A==0)
//                    return i;
//                continue;
//            }

            mx += k;

            if (mx < A)
                continue;

            int rest = mx-A;                                      //这才是某些需要双转的数字的个数

            if (rest%2==0)                                     //这是针对 k>A 的情况
            {
                rest = rest/2;
                double dou1 =  A*Math.floor((i-1)/2.0);           //对于初始为0的， 这个数最多(即x次都用在上面)的双转次数为 floor((x-1)/2)
                double dou2 =  B*Math.floor(i/2.0);               //对于初始为1的， 这个数最多的双转次数为 floor(x/2)

                if (rest <= dou1 + dou2)                            // dou,dou1 必然有一个被取整后，减小了 ，这里没有=
                    return i;

            }
        }

        return -1;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A,B,k;
        A = in.nextInt();
        B = in.nextInt();
        k = in.nextInt();

        int res = solotion(A,B,k);
        System.out.println(res);


    }
}
