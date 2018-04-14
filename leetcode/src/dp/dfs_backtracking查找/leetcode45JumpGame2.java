package dp.dfs_backtracking查找;
import java.lang.*;
/**
 * Created by Gracecoder on 2017/4/26.
 */
public class leetcode45JumpGame2 {


    /*
    这题不同于上题，只要求我们得到最少的跳跃次数，所以铁定能走到终点的，这里仍然使用贪心法。
    维护两个变量，当前能达到的最远点p以及下一次能达到的最远点q，在p的范围内迭代计算q，然后更新步数，并将最大的q设置为p，重复这个过程知道p达到终点
     */
    public static int jump(int[] nums) {


        int cur=0,step=0,next=0;

        int i = 0;
        while (i < nums.length)
        {
            if (next >= nums.length -1)
                break;

            while (i <= cur)
            {

                next = Math.max(next,nums[i]+i);
                i++;
            }

            step++;
            cur = next;
        }

        return step;

    }

    public static void main(String[] args){
        int result = jump(new int[]{1,2,3});
        System.out.println(result);

    }


}
