package 深信服6_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 19:34
 * @Description:
 */
public class 数组排序 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);

        String[] nums = new String[n+1];
        for (int i = 1 ; i < parts.length ; i++)
            nums[i] = parts[i];

        StringBuilder sb = new StringBuilder("#");
        for (int i = 1 ; i < nums.length ; i++)
            sb.append(nums[i]);

        int ans = 0;

        for (int i = 1 ; i <= n;i++)
        {
            String tmp = String.valueOf(i);
            int index = sb.indexOf(tmp);
            if (index == i)
                continue;

            ans++;

            String pre = sb.substring(0,i);
            String cur = sb.substring(i,index+1);
            String tail = sb.substring(index+1);
            StringBuilder reverse = new StringBuilder(cur);
            cur = reverse.reverse().toString();
            sb.delete(0,sb.length());
            sb.append(pre).append(cur).append(tail);
        }

        System.out.println(ans);


    }
}
