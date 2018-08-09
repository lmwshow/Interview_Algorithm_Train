package Top_Interview_Questions_2;

public class Question55_跳到目的 {




    //超时
    public static boolean canJumpDFS(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return true;

        //深搜路径
        return solver(nums,0);
    }

    private static boolean solver(int[] nums, int curindex) {

        if (curindex >= nums.length-1)
            return true;

        boolean ans = false;
        for (int i = 1 ;i <= nums[curindex] ;i++)
            ans = ans || solver(nums,curindex+i);

        return ans;
    }

    /*
    --------------
     */


    public static boolean canJump(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return true;

        //遍历一次
        int step = nums[0];
        for (int i = 1 ; i < nums.length ; i++)
        {
            step--;
            if (step<0)
                return false;

            step = Math.max(nums[i],step);
        }

        return true;


    }

    public static boolean mwcanJump(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return true;

        //遍历一次
        int index = 0;
        int step = nums[0];

        while (step > 0)
        {
            if (step + index >= nums.length - 1)
                return true;
            step --;
            index ++;
            if (nums[index] > step)
                step = nums[index];
        }

        return false;


    }


    public static void main(String[] args){

        boolean ans = canJump(new int[]{0});

        System.out.println(ans);

    }
}
