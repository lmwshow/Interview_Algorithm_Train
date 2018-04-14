package pingduoduo0801;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/8/1.
 */
public class 无序数组3个数最大乘积 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] nums = new long[n];

        for (int i = 0 ; i < n; i++)
            nums[i] = in.nextLong();

        Arrays.sort(nums);
        long res1 =1;
        long res2 =1;

        for (int i = nums.length-1; i > nums.length - 4;i--)
            res1 *= nums[i];

        res2 = nums[0]*nums[1]*nums[nums.length-1];

        System.out.println(res1>res2?res1:res2);

    }
}
