package 头条;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/8/12 10:37
 * @Description:
 */
public class 区间最大最小值 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] Aparts = in.readLine().split(" ");
        String[] Bparts = in.readLine().split(" ");
        int[] aArray = new int[n];
        int[] bArray = new int[n];

        for (int i = 0 ; i < n ; i++) {
            aArray[i] = Integer.parseInt(Aparts[i]);
            bArray[i] = Integer.parseInt(Bparts[i]);
        }

        int ans = 0;

        for (int i = 0 ; i < n ; i++)
            for (int j = i ; j < n ; j++)
                if (find(aArray,i,j,false) < find(bArray,i,j,true))
                    ans++;


        System.out.println(ans);

    }

    private static int find(int[] aArray, int start, int end, boolean flag) {


        int ans = 0;
        if (!flag)
        {
            //找最大值
            int max = 0;
            for (int i = start ; i <= end; i++)
                max = Math.max(max,aArray[i]);

            ans = max;
        }
        else
        {
            //找最小值
            int min = Integer.MAX_VALUE;
            for (int i = start ; i <= end; i++)
                min = Math.min(min,aArray[i]);

            ans = min;
        }

        return ans;

    }
}
