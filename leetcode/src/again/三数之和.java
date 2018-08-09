package again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/7 09:51
 * @Description:
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return ans;

        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();

        /*
        固定一个，再剩下的中找towSum, 由于已经进行排序，也就不需要Map辅助。
        左右指针，就能达到O(n) 查找twoSum的效果
         */
        for (int i = 0 ; i < nums.length - 2 ; i++)
        {
            //如果第一个数大于0，那就没有可行解了
            if (nums[i] > 0)
                break;

            //避免重复
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            tmp.add(nums[i]);
            twoSum(nums,ans,tmp,-nums[i],i+1);
            tmp.clear();
        }

        return ans;

    }

    private void twoSum(int[] nums, List<List<Integer>> ans, List<Integer> tmp, int target,int start) {

        int left = start;
        int right = nums.length - 1;

        while (left < right)
        {
            if (nums[left] + nums[right] == target)
            {
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                ans.add(new ArrayList<>(tmp));
                tmp.clear();

                tmp.add(nums[start - 1]);

                while (left < right && nums[left] == nums[left + 1])
                    left ++;
                while (left < right && nums[right] == nums[right - 1])
                    right --;

                left ++;
                right --;
            }else if (nums[left] + nums[right] < target)
                left ++;
            else
                right--;
        }

    }
}
