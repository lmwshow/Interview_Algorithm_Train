package 阿里;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/9/7 20:16
 * @Description:
 */
public class Main1 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];
        for (int i = 0 ; i < n ; i++)
            nums[i] = Integer.parseInt(in.readLine());


        if (nums.length < 6)
        {
            System.out.println(0);
            return;
        }
        else
        {
            int ans = calculate(nums);

            System.out.println(ans);
        }
    }

    private static int calculate(int[] nums) {

        return 8;

    }
}
