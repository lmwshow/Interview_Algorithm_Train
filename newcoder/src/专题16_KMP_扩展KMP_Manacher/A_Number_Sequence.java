package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/19.
 *
 * 题意就是找p在s的子串，返回最小的开始index
 */
public class A_Number_Sequence {

    private static int[] next;

    private static void getNext(int[] p)
    {
        int k = -1;
        int j = 0;          //k表示前缀,j表示后缀
        next[0] = -1;

        while (j < p.length)
        {
            if (k == -1 || p[k] == p[j])
            {
                k++;
                j++;
                next[j] = k;    //相当于next[j+1] = next[j] + 1 = k + 1;
            }else
                k = next[k];    //不断递归前缀索引
        }
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int M = 0,N = 0,start = 0;

        while (n-- > 0)
        {
            N = in.nextInt();
            M = in.nextInt();

            int[] a = new int[N];
            int[] b = new int[M];

            for (int i = 0 ; i < N ; i++)
                a[i] = in.nextInt();
            for (int i = 0 ; i < M ; i++)
                b[i] = in.nextInt();

            next = new int[M+1];

            getNext(b);

            start = kmp(a,b);

            System.out.println(start);

        }

        return;


    }

    private static int kmp(int[] a, int[] b) {

        int i = 0,j = 0;

        int lena = a.length , lenb = b.length;

        while (i < lena && j < lenb)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 ||a[i] == b[j])
            {
                i++;
                j++;
            }else
                j = next[j];
            //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
            //next[j]即为j所对应的next值

        }

        if (j == lenb)
            return i - j +1;

        return -1;
    }
}
