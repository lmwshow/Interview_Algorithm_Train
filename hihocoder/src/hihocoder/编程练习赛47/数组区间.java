package hihocoder.编程练习赛47;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 数组区间 {

    public static int Patition(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int key = nums[0];

        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while (left < right) {
            while (nums[right] >= key && right > left)
                right--;
            nums[left] = nums[right];
            while (nums[left] <= key && left < right)
                left++;
            nums[right] = nums[left];

        }

        nums[left] = key;
        if (left == k - 1) {
            for (int i = 0; i < k; i++)
                sum += nums[i];
            return sum;
        }

        return sum;

    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++)
            nums[i] = in.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int res = 0;

        int[] dp = new int[n+1];

        int curSum = 0;
        for (int i = 1 ; i <= n ; i++)
        {
            if (i <= k)
            {
                pq.offer(nums[i]);
                curSum += nums[i];
                res += curSum;
            }
            else {
                if (nums[i] > pq.peek())
                {
                    curSum += nums[i] - pq.poll();
                    pq.offer(nums[i]);
                }

                res += curSum;
            }

            dp[i] = curSum;
        }

        for (int i = 2; i <= n; i++) {
            curSum = 0;
            for (int j = i; j <= n; j++) {
                if (j - i + 1 <= k)
                {
                    curSum += nums[j];
                    res += curSum;
                }
                else
                    res += dp[j];
            }
        }

        System.out.println(res);


    }
}
