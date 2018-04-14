package 真题;

import java.util.Arrays;
import java.util.Scanner;

public class 洗牌 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] nums = new int[2 * n];
            for (int i = 0; i < nums.length; i++)
                nums[i] = in.nextInt();


            while (k-- > 0) {
                int[] pre = Arrays.copyOf(nums, n);
                int index = 0;
                for (int i = 0; i < pre.length; i++) {
                    nums[index++] = pre[i];
                    nums[index++] = nums[i + n];
                }
            }


            System.out.print(nums[0]);

            for (int i = 1; i < nums.length; i++)
                System.out.print(" " + nums[i]);

            System.out.println();




        }


    }
}
