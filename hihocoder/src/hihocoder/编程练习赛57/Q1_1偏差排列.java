package hihocoder.编程练习赛57;

import java.util.List;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/4/29 12:04
 * @Description: http://hihocoder.com/contest/offers57/problem/1
 * <p>
 * 如果一个1~N的排列P=[P1, P2, ... PN]中的任意元素Pi都满足|Pi-i| ≤ 1，我们就称P是1-偏差排列。
 * <p>
 * 给定一个N，请你计算一共有少个不同的排列是1-偏差排列。
 *
 * 根据全排列答案 看出 规律  f[n] = f[n-1]+f[n-2]
 */
public class Q1_1偏差排列 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long[] ans = new long[51];
        ans[1] = 1;
        ans[2] = 2;

        int n = in.nextInt();
        for (int i = 3; i <= n;i++)
            ans[i] = ans[i-1]+ans[i-2];

        System.out.println(ans[n]);

//        while (true) {
//            int n = in.nextInt();
//
//            if (n < 2) {
//                System.out.println(n);
//            }
//            else {
//                int ans = 0;
//                int[] nums = new int[n];
//                for (int i = 0; i < n; i++)
//                    nums[i] = i;
//
//                List<Integer> tmp = new ArrayList<>();
//
//
//                do {
//                    for (int x : nums)
//                        tmp.add(x);
//                    if (isAns(tmp))
//                        ans++;
//                    tmp.clear();
//                } while (nextPermutation(nums));
//
//                System.out.println(ans);
//            }
//        }
    }

    public static boolean nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2)
            return true;

        int i = nums.length - 2;

        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int find = nums.length - 1;
                while (nums[find] <= nums[i])
                    find--;
                swap(nums, i, find);
                reverse(nums, i + 1);
                return true;
            }

        }

        reverse(nums, 0);
        return false;

    }

    //利用swap 来逆转
    private static void reverse(int[] nums, int start) {

        int end = nums.length - 1;
        while (start < end)
            swap(nums, start++, end--);
        return;
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    private static boolean isAns(List<Integer> tmp) {

        boolean ans = true;
        for (int i = 0; i < tmp.size(); i++) {
            if (Math.abs(tmp.get(i) - i) <= 1)
                continue;
            else {
                ans = false;
                break;
            }
        }

        return ans;

    }
}
