package Top_Interview_Questions_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/4/27 09:24
 * @Description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 因为数组中的数，在1<=x<=n(n表示数组的长度)，我们很容易将数组根据下标想像成链表
 */
public class Question448_找到所有数组中消失的数字 {

    //用相反数来标记当前下标已被访问过，同时还能获取当前下标原来的值，这样就在不需要额外空间的前提下达到O(n)的复杂度
    public List<Integer> better_findDisappearedNumbers(int[] nums) {

        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int pre = 0,cur = 0;

        for (int i = 0 ; i < nums.length ; i++)
        {
            if (nums[i] != 0)           //表示没访问过
            {
                pre = nums[i] -1;                     //根据这个点循环访问链表
                while (nums[pre]!=0)
                {
                    cur = nums[pre] - 1;
                    nums[pre] = 0;
                    pre = cur;
                }

            }

        }

        for (int i = 0 ; i < nums.length ; i++ )
            if (nums[i]!=0)
                ans.add(i+1);

        return ans;

    }
}
