package 贝壳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/8/18 19:45
 * @Description:
 */
public class 道路修建 {


    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        String[] parts = in.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(parts[i]);


        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++)
            ans += Math.max(nums[i],nums[i+1]);

        System.out.println(ans);


    }
}
