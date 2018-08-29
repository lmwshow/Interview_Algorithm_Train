package Top_Interview_Questions_2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/5/2 08:59
 * @Description: https://leetcode-cn.com/problems/subarray-sum-equals-k/description/
 *
 *
 * 使用hashmap 保存前缀和的个数
    e.g. [a, b, c, d, e]
    sum[1] = a + b;
    sum[4] = a + b + c + d + e;
    if sum[4] - sum[1] = k, Subarray [c, d, e] sum equals k (that's our target)
    so for sum[i], we check if sum[i] - k met
    Thus, we build hashmap<cummulativeSum, frequencies>
 */
public class Question560_和为K的子数组 {

    static int ans;

    //滑动窗口
    public static int subarraySum(int[] nums, int k) {

        ans = 0;
        if (nums == null)
            return ans;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);           //初始化，前缀和为0的 个数初始化为1
                                // if [1, 1], k = 2, cummulativeSum = k, also valid, should increase ans by 1
        int cur = 0;

        for (int i = 0 ; i <nums.length ; i++)
        {
            cur += nums[i];
            if (map.containsKey(cur-k))
                ans += map.get(cur-k);

            map.put(cur,map.getOrDefault(cur,0)+1);
        }

        return ans;


    }

        //DP超时
    public int DPsubarraySum(int[] nums, int k) {

        ans = 0;
        if (nums == null)
            return ans;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            if (dp[i][i] == k)
                ans++;
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] == k)
                    ans++;
            }


        return ans;
    }

    public static void main(String[] args){

        int[] nums = new int[]{1};

        System.out.println(subarraySum(nums,0));
    }
}
