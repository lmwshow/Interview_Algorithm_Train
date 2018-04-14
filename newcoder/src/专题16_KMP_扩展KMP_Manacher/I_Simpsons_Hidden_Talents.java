package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/28.
 *
 * 求字符串s1前缀和字符串s2后缀相等的最长长度
 *
 * 那就是把s1,s2连接起来，next[totallen]
 *
 * s1 s2 各自最多50000长度， 加起来100000，Wrong answer  内存会超过吧
 *
 * 不如换一种想法，因为需要s1的前缀和s2的后缀相同，  将s2当做原串，用s1去匹配，s1不断后移，直到遍历完s2此时s1的索引就代表了 匹配的长度
 */
public class I_Simpsons_Hidden_Talents {

    private static int[] next;

    private static void getNext(String p)
    {
        int k = -1;
        int j = 0;

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


    public static void kmp(String s,String p)
    {
        int i = 0;
        int j = 0;

        while (i < s.length() && j< p.length())
        {
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }else
            {
                j = next[j];
            }
        }

        if (j == 0)
            System.out.println(0);
        else
            System.out.println(p.substring(0,j) + " " + j);


    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        while (true)
        {
            String s1 = in.next();
            String s2 = in.next();

            next = new int[s1.length()+1];

            getNext(s1);

            kmp(s2,s1);
        }


    }


}
