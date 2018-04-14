package Top_Interview_Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/11/16.
 *
 * 要抓住元素 大小在 1<=x<=n  n为数组长度  这一特性
 * 这一 元素大小 就可以和数组下标联系起来， 不断将已经有的元素的对应下标 的元素置为0，然后更新下一个，直到下一个已经为0.
 *
 * 遍历整个数组，对还未访问过的元素，访问一遍。思想类似图的遍历，避免不是连通图。
 *
 *
 *
 * 解法2：用相反数表示，这个下标已经访问过，这样不需要额外空间且O（n）内完成。然后用val = Math.abs(nums[i]) - 1 表示指向的下一个位置下标
 */
public class Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int pre = 0;
        int cur = 0;

        for (int i = 0 ; i < nums.length ; i++)
        {
            if (nums[i]!=0)
            {
                pre = nums[i] - 1;              //因为数组大小为n，元素为1到n  所以要减1
                while (nums[pre] != 0)
                {
                    cur = nums[pre] -1;
                    nums[pre] = 0;
                    pre = cur;
                }
            }
        }

        for (int i = 0 ; i < nums.length ; i++ )
            if (nums[i]!=0)
                res.add(i+1);

        return res;

    }

    public List<Integer> better_findDisappearedNumbers(int[] nums) {

        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
