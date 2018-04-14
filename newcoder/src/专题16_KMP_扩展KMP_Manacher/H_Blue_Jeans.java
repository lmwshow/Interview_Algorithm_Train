package 专题16_KMP_扩展KMP_Manacher;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/26.
 * <p>
 * 题意：找出数条定长的字符串中的最长公共子串
 * 巨土暴力， 找出最长公共子串，相同长度时，取字典序大的
 * 遍历所有长度的子串，这时候next数组每次都需要重新计算，以后起点和终点是不定的
 * 从长的开始，找到一个公共子串时，跳过所有j-i+1 < max  即不存在解的情况 剪枝
 */
public class H_Blue_Jeans {

    private static int[] next;

    private static void getNext(String p) {
        int k = -1;
        int j = 0;

        next[0] = -1;

        while (j< p.length())
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

    private static boolean kmpCompare(String s,String p)
    {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length())
        {
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }else
                j = next[j];

            if (j == p.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args){

        Scanner in =new Scanner(System.in);

        ArrayList<String> list = new ArrayList();

        int N = in.nextInt();

        int M = 0;

        int index = 0;
        int i = 0;
        int j = 0;


        while (N-- >0)
        {
            M = in.nextInt();

            for (i = 0 ; i < M ; i++)
                list.add(in.next());

            String cur = list.get(0);


            int max = 0;
            int start = 0;
            int end = 0;


            for (i = 0; i <=57 ;i++)
                for (j = 59 ; j >= i+2 ; j--)
                {
                    int len = j - i +1;

                    if (len < max)
                        continue;

                    String tmp = cur.substring(i,j + 1);
                    next = new int[tmp.length() +1];
                    getNext(tmp);

                    for (index = 1;index < M ; index ++)
                    {
                        if (!kmpCompare(list.get(index),tmp))
                            break;
                    }

                    if (index == M)
                    {

                        if (len >= max)
                        {
                            if (len > max || (len == max && cur.substring(i,j+1).compareTo(cur.substring(start,end+1)) < 0)) {
                                max = j - i + 1;
                                start = i;
                                end = j;
                            }
                        }
                    }

                }

            if (end == 0 && start ==0)
                System.out.println("no significant commonalities");
            else
                System.out.println(cur.substring(start,end+1));

            list.clear();


                
        }

    }


}
