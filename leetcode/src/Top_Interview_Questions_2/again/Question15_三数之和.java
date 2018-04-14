package Top_Interview_Questions_2.again;

import java.util.*;

public class Question15_三数之和 {

    //普通深搜超时

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();

        for (int i = 0 ; i < nums.length - 2 ; i++)
        {
            //如果第一个数大于0，那么就不存在可行解了
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i-1])
                continue;

            cur.add(nums[i]);
            twoSum(res,cur,nums,i+1,-nums[i]);
            cur.clear();
        }

        return res;

    }

    private static void twoSum(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, int target) {

        int left = start;
        int right = nums.length-1;

        while (left < right)
        {
            if (nums[left] + nums[right] == target)
            {
                cur.add(nums[left]);
                cur.add(nums[right]);
                res.add(new ArrayList<>(cur));
                cur.clear();
                cur.add(nums[start-1]);

                while (left < right && nums[left+1]==nums[left])
                    left++;
                while (left < right && nums[right - 1] == nums[right])
                    right--;

                left++;
                right--;


            }else if (nums[left] + nums[right] > target)
                right--;
            else
                left++;

        }
    }


    public static void main(String[] args){

        int nums[] = new int[]{0,0,0,0};
        List<List<Integer>> res = threeSum(nums);

        for (int i = 0 ; i < res.size() ; i++)
        {
            List<Integer> tmp = res.get(i);
            System.out.println(tmp.size());

            for (int x :
                    tmp) {
                System.out.println(x);

            }
        }

    }
}
