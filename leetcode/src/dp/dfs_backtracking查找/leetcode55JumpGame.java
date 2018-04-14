package dp.dfs_backtracking查找;

/**
 * Created by Gracecoder on 2017/4/21.
 */
public class leetcode55JumpGame {

    private boolean flag = false;
    public static boolean DFScanJump(int[] nums) {

        leetcode55JumpGame result = new leetcode55JumpGame();
        if (nums.length == 0 || nums.length ==1)
            return true;

        DFS(result,nums,0);
        return result.flag;
    }

    public static void DFS(leetcode55JumpGame result, int[] nums, int index) {

        if (index == nums.length-1)
        {
            result.flag = true;
            return;
        }
        else if (index >= nums.length)
            return;
        else
            for (int i = 1 ; i <= nums[index] ; i++)
                DFS(result,nums,index+i);
    }




/*
  使用贪心：每跳一步，步数减少一步。比较当前位置的步数是否大于剩余步数，如果大于就重新赋值，小于就略过。如果剩余步数小于0还没到达，那就失败了！
 */

    public static boolean canJump(int[] nums) {

        if (nums.length == 0)
            return true;

        int step = nums[0];

        for (int i = 1; i <nums.length; i ++)
        {
            step --;

            if (step < 0)
                return false;

            if (nums[i] > step)
                step = nums[i];
        }

        return true;
    }

    public static void main(String[] args){

        boolean result = canJump(new int[]{2,0,0});
        System.out.println(result);

    }
}
