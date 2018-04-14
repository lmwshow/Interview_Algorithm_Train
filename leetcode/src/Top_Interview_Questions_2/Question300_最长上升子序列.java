package Top_Interview_Questions_2;

public class Question300_最长上升子序列 {

    //经典题：LIS

    //解法1：DP  O(n^2)
    //状态定义： dp[i] 代表以nums[i]结尾的LIS的长度
    //由于以nums[i]结尾的LIS 可能有多种路径，我们需要最长的长度，所以对每个dp[i]  需要从[0，i-1]遍历更新dp[i]
    //状态转移方程：  dp[i]= max(dp[i],dp[j]+1)  (0<=j<i,nums[j]<nums[i])
    public int DPlengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        for (int i = 0 ; i < nums.length ; i++)
            dp[i] = 1;

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }

        }
        for (int i = 0 ; i < nums.length ; i++)
            ans = Math.max(dp[i],ans);

        return ans;

    }


    //解法2：贪心 + 二分   O(nlogn)
    //low[i] 代表长度为i的LIS结尾元素的最小值。对于一个上升序列，显然其结尾元素越小，越有利于在后面接其他元素，也就可能变得更长
    //维护low数组，对于每个nums[i]，如果nums[i]>low[当前最长的LIS长度]，就把nums[i]接到当前最长的LIS后面
    //即low[++当前最长的LIS长度]=nums[i]
    //否则的话，就需要用nums[i]去更新low数组，具体的方法是在low数组中找到第一个大于等于a[i]的元素，用nums[i]去更新low[j]
    //low[j] = nums[i]  表示更新长度为j的LIS结尾元素的最小值
    //这里由于low数组时一个单调不降的，所以查找可以使用二分
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[] low = new int[nums.length+1];

        for (int i = 1; i < low.length ; i++)
            low[i] = Integer.MIN_VALUE;

        low[1] = nums[0];

        int ans = 1;
        for (int i = 1; i < nums.length ; i++) {

            if (nums[i] > low[ans])
                low[++ans] = nums[i];   //当nums[i]大于，当前最长递增子序列尾部最小值时， 更新最长长度并赋值low[++ans] = nums[i]

            else
                low[binarySearch(low,nums[i],ans)] = nums[i];   //否则，找到low中第一个大于等于nums[i]的位置low[j]，更新当前最小值

        }

        return ans;

    }

    private int binarySearch(int[] low, int target, int end) {

        int left = 1;
        int right = end;
        int mid = 0;
        while (left <= right)
        {
            mid = ((right -left) >> 1) + left;

            if (low[mid] > target)
                right = mid - 1;
            else if (low[mid] < target)
                left = mid + 1;
            else
                return mid;
        }

        return left;

    }


}
