package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/21.
 *
 * 求需要加最少的字符，是原串构成循环串，关键求最小循环节
 *
 * 失配函数构造next数组的性质的应用，需要对这个有真正的理解。
 * 对于长度为len的字符串，假设已经够造完了next数组，那么len-next[len]就是这个字符串的最小循环节。
 * 如果正好len%(len-next[len])==0就说明正好组成完成的循环。
 * 否则，说明还需要再添加几个字母才能补全。
 * 需要补的个数是循环个数len-next[len]-f[len]%(len-next[len]).
 * f[len]%(len-next[len])表示在最后一个循环节中已经构造了这么多个数。
 *
 */
public class D_Cyclic_Nacklace_最小循环节 {

    private static int[] next;

    private static void getNext(String p)
    {
        int k = -1;
        int j = 0 ;
        next[0] = -1;

        while (j < p.length())
        {
            if (k == -1 || p.charAt(k) == p.charAt(j))
            {
                k++;
                j++;
                next[j] = k;
            }else
                k = next[k];

        }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        int minCyclicLen = 0;

        int res = 0;

        while (T -- > 0)
        {


            String str = in.next();
            int len = str.length();


            next = new int[len +1];
            getNext(str);

            minCyclicLen = len - next[len];


            if (len!=minCyclicLen && len%minCyclicLen==0)
                res = 0;
            else
                res = minCyclicLen - len%minCyclicLen;
//            if (next[len] == 0)
//                res = len;
//            else if (len % minCyclicLen == 0)
//                res = 0;
//            else
//                res = minCyclicLen - (len % minCyclicLen);

            System.out.println(res);



        }

    }
}
