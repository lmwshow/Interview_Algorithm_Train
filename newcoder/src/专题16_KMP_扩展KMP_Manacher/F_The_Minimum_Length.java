package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/24.
 */
public class F_The_Minimum_Length {

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

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        while (true)
        {
            String str = in.next();
            if (str == null)
                return;

            next = new int[str.length() +1];

            getNext(str);

            System.out.println(str.length() - next[str.length()]);

        }

    }
}
