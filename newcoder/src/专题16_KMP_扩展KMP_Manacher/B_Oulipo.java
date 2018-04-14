package 专题16_KMP_扩展KMP_Manacher;

import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/19.
 *
 * 题意：找模式串p 在 文本中出现的次数，可以部分重合
 */
public class B_Oulipo {

    private static int[] next;

    private static void getNext(String p)
    {
        int k = -1;
        int j = 0;          //k表示前缀,j表示后缀
        next[0] = -1;

        while (j < p.length())
        {
            if (k == -1 || p.charAt(k) == p.charAt(j))
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

        int res = 0;
        while (n-- > 0)
        {
            String p = in.next();           //输入字符串 不能用nextLine()  那样text直接会是 回车
            String text = in.next();
            int count = 0;

            next = new int[p.length()+1];

            getNext(p);



            res = kmp(text,p);

            System.out.println(res);

        }

        return;


    }

    private static int kmp(String text, String p) {

        int i = 0,j = 0 , count = 0;

        int lenText = text.length() , lenP = p.length();

        while (i < lenText && j < lenP)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 ||text.charAt(i) == p.charAt(j))
            {
                i++;
                j++;

                if (j == lenP)
                {
                    count++;
                    j = next[j];
                }
            }else
                j = next[j];
            //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
            //next[j]即为j所对应的next值

        }

        return count;

    }
}
