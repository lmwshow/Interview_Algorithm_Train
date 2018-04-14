package Top_Interview_Questions.dp.again;

/**
 * Created by Gracecoder on 2017/10/13.
 *
 * 用dfs超时
 *
 * 题意：本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。那么我们对于这类求极值的问题首先考虑动态规划Dynamic Programming来解
 *
 * 在dfs超时的时候，有想到用dp，但是觉得行不通，看样子对dp理解的还是不深刻，爱钻牛角尖
 *
 * 自己的想法： 用dp  那么 dp[i]表示到达i位置时不相邻数的最大和。那么dp[i]和dp[i-1]是什么关系呢？
 *            例子： nums{1,2,4,8}  当dp[2] = 5 时 dp[3]本应该选2,8 等于10，
 *                  认为自己需要选择8而dp[2]是选择4 ，好像跟dp[2]没有任何关系,然后就觉得dp行不通
 *                  但是和dp[2]没关系，确实是符合逻辑的，我们需要找到正确的递推式，和dp[2]没联系 那和 前面的dp[1]呢？
 *
 * dp的本质是将问题分成小问题，然后去递推。
 *            上面的例子，既然我们选择8，那么dp[3]实际上确实和dp[2]已经没有关系了，因为选择8 就不能有4 ，所以选择8的情况下的和 是nums[3]+dp[1]
 *            而对于每个数字只有选和不选两种情况，dp[i] = max(dp[i-1],nums[i]+dp[i-2])
 *
 * 动态转移方程： dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
 */
public class House_Robber {

    private static int max;

    public static int rob(int[] nums) {

        if (nums.length <= 1)
            return nums.length == 0? 0 : nums[0];


        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length ; i++)
            dp[i] = Integer.max(dp[i-1],dp[i-2]+nums[i]);

        return dp[nums.length-1];
    }


    //还有一种解法，核心思想还是用DP，分别维护两个变量a和b，然后按奇偶分别来更新a和b，这样就可以保证组成最大和的数字不相邻，代码如下：
    public static int rob2(int[] nums) {

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                a += nums[i];
                a = Integer.max(a, b);
            } else {
                b += nums[i];
                b = Integer.max(a, b);
            }
        }
        return Integer.max(a, b);
    }



    public static int dfsrob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];


        max = Integer.MIN_VALUE;

        DFS(nums,0,0);

        return max;
    }

    private static void DFS(int[] nums, int start, int sum) {

        if (start >= nums.length)
        {
            max = sum>max?sum:max;
            return;
        }


        for (int i = start ; i < nums.length ; i++)
        {
            DFS(nums,i+2,sum+nums[i]);

            DFS(nums,i+1,sum);
        }

    }


    public static void main(String[] args){

        int[] nums = new int[]{183,219,57,193,94,233,202,154,65,240,97};
        System.out.println(rob(nums));


    }
}
