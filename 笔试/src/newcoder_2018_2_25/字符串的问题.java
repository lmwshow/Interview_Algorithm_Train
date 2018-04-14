package newcoder_2018_2_25;

import java.util.Scanner;

public class 字符串的问题 {

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
        String str = in.next();
        int length = str.length();
        String restr = "Just a legend";
        for(int i = 1;i<=length-2;i++){
            String pre  = str.substring(0, i);
            String suf = str.substring(length-i);
            String mid = str.substring(1, length -1);
            if(pre.equals(suf) && mid.contains(pre) ){
                restr = pre;
            }
        }
        System.out.print(restr);
            
            



    }
}
