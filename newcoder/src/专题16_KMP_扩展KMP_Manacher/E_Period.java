package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/24.
 *
 * 题意：求长度至少为2的前缀，是否构成循环节，如果是循环节，求出最大循环次数,即求最小循环节同理
 */
public class E_Period {

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
            }
            else
                k = next[k];
        }
    }







    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N;

        int minCycle = -1;

        int len = 0;
        
        int k = 1;

        while ((N=scanner.nextInt()) != 0)
        {
            String str = scanner.next();
            

            next = new int[str.length() + 1];

            getNext(str);
            
            System.out.println("Test case #" + k++);
            

            for (int i = 1 ; i < str.length() ; i++)
            {
                len = i+1;
                minCycle = len - next[len];
                if (minCycle != len && len %minCycle == 0)
                {
                    System.out.println(len + " " +len/minCycle);

                }
            }
            System.out.println();
            
        }

    }


}
