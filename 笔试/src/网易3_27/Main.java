package 网易3_27;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;



//
//对于一个b, n范围内的数模b的序列应该是:
//0,1,2,...,b-1, 0, 1, 2,..., b-1,...0,1,2,..n%b
//前面部分是个循环节,所以可以通过(n / b) * max(0, b - k)计算。
//后面部分是max(0, n % b - k + 1),
//于是我们枚举合法的b计算就可以了。
//k = 0的情况特判处理。

public class Main {

    public static void main(String[] args){


        Scanner in =  new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        long ans = 0;
        if (k == 0)
        {
            ans = (long)n*(long)n;
        }
        else {
            for (int x = k; x <= n; x++) {
                ans += (n / x) * Math.max(0, x - k);
                if (n % x >= k) ans += n % x - k + 1;
            }
        }

        System.out.println(ans);





    }


}
