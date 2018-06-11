package hihocoder.编程练习赛62;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: minGW
 * @Date: 2018/6/3 13:02
 * @Description
 */
public class 金额组合 {



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Set<Long> set = new HashSet<>();
        int n = in.nextInt();
        long c = in.nextLong();

        long[] nums = new long[n];

        for (int i = 0; i < n; i++)
            nums[i] = in.nextLong();

        boolean[] visit = new boolean[n];

        Arrays.sort(nums);

        DFS(nums, visit, 0,0, c,set);

        System.out.println(set.size());

    }

    private static void DFS(long[] nums, boolean[] visit,int start, long curSum, long target,Set<Long> set) {

        if (curSum > target)
            return;

        for (int i = start ; i < nums.length; i++) {

            if (nums[i] > target)
                break;
            if (visit[i])
                continue;

            visit[i] = true;
            if (curSum + nums[i] <= target)
                set.add(curSum + nums[i]);
            DFS(nums, visit, i+1,curSum + nums[i], target,set);
            visit[i] = false;

        }
    }
}
