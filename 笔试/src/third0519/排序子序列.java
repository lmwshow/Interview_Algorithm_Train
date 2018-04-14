package third0519;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/5/19.
 *于是我们可以贪心的去重复下面过程:
 1、 从序列中找出最长的单调连续子序列
 2、 删除找出的最长的单调连续子序列
 *
 */
public class 排序子序列 {



    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList();

        int res = 1;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A =new int[n];
        for (int i = 0 ; i < n; i ++) {

            int x;
            x = in.nextInt();
            if (list.size() <= 1)
                list.add(x);

            else {
                int last = list.get(list.size() - 1);
                if (list.get(0) >= last && last >= x)
                    list.add(x);
                else if (list.get(0) <= last && last <= x)
                    list.add(x);
                else
                {
                    res++;
                    list.clear();
                    list.add(x);
                }
            }
        }

//        res = solution(A);
        System.out.println(res);



    }
}
