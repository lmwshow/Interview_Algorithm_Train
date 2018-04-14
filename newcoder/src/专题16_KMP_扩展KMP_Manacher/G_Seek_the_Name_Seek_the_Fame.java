package 专题16_KMP_扩展KMP_Manacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/9/24.
 *
 * 求出字符串 所有长度的相同前缀和后缀
 * 理解next数组
 * 首先最长的相同前后缀就是字符串本身的长度,紧接着就是next[len]的长度
 * next[len]表示字符串p(0,len-1)中相同前后缀的长度，即表示p(0,next[len]-1)  == p(len-next[len],len-1)  就是一样的字符串，这样才能递归进去
 *
 * 那么紧接着的相同前后缀 就是 next[next[len]]了  递归下去直到长度为0
 *
 * answer： len,next[len],next[next[len]]....0  (大于0)
 */
public class G_Seek_the_Name_Seek_the_Fame {

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

        ArrayList<Integer> cur = new ArrayList<>();

        next = new int[400001];
        int index = 0;
        
        while (true)
        {


            String p = in.next();

            if (p == null)
                return;
            next = new int[p.length() + 1];
            getNext(p);
            
            index = p.length();

            cur.add(index);

            while (next[index]>0)
            {
                cur.add(0,next[index]);           //因为res需要从小到大输出，这里就逆序插入
                index = next[index];                    //不断往前递归
            }
            
            for (int i = 0 ;i < cur.size() ; i++)
            {
                System.out.print(cur.get(i));
                if (i != cur.size() -1)
                    System.out.print(" ");

            }


            cur.clear();
            System.out.println();
            
            
        }

    }
}
