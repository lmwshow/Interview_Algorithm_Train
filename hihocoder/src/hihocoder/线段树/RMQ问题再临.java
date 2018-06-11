package hihocoder.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/11 09:26
 * @Description: http://hihocoder.com/problemset/problem/1070
 *
 *
 * 针对数据量小，可以使用暴力，遍历查找区间O(n)， 单点修改O(1)
 * 在ST算法的基础上修改的话，每次询问还是O(1)的时间复杂度，不过每次修改的时候，因为pre_calc数组里面大概有2N个（1+2+4+...）区间包含到了这个位置，所以这O(N)项都要重新进行计算
 * 就是说 两种方案，两个操作的复杂度都不平衡
 *
 * 如何能平衡呢， 线段树！
 * 单点修改，区间查询
 *
 * 这里先用朴素的方法暴力
 */
public class RMQ问题再临 {
    static int maxN = 10001;
    static int[] nums = new int[maxN];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] parts = in.readLine().split(" ");

        for (int i = 0 ; i < parts.length ; i++)
            nums[i+1] = Integer.parseInt(parts[i]);

        int q = Integer.parseInt(in.readLine());

        while (q-- > 0)
        {
            parts = in.readLine().split(" ");
            int opt = Integer.parseInt(parts[0]);
            if (opt == 0)
            {
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                int curmin = nums[l];
                for (int i = l ; i <= r ; i++)
                    curmin = Math.min(curmin,nums[i]);
                System.out.println(curmin);
            }
            else {

                nums[Integer.parseInt(parts[1])] = Integer.parseInt(parts[2]);
            }
        }
    }

}
