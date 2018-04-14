package Top_Interview_Questions_2;

public class Question152_乘积最大子序列 {

    //求乘积最大的连续子序列，由于算的是乘积，有正有负，所以应该维护两个dp数组 记录最大值和最小值
    //dpMax[i]表示以i为结束点的子序列的最大乘积
    public static int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = dpMin[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length ;i++)
        {
            dpMax[i] = Math.max(Math.max(dpMin[i-1]*nums[i],dpMax[i-1]*nums[i]),nums[i]);
            ans = Math.max(ans,dpMax[i]);

            dpMin[i] = Math.min(Math.min(dpMin[i-1]*nums[i],dpMax[i-1]*nums[i]),nums[i]);

        }

        return ans;
    }


    public static void main(String[] args){

        int[] nums = new int[]{2,-1};

        System.out.println(maxProduct(nums));


    }
}
