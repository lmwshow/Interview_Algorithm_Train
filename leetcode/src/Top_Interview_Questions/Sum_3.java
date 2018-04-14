package Top_Interview_Questions;

import java.util.*;

/**
 * Created by Gracecoder on 2017/10/3.
 *
 * 3个数之和，比之前那道Two Sum 两数之和要复杂一些，
 * 我们还是要首先对原数组进行排序，然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了
 * 然后我们还要加上重复就跳过的处理，对于遍历到的数，我们用0减去这个数得到一个sum，我们只需要再之后找到两个数之和等于sum即可，
 * 这样一来问题又转化为了求two sum，这时候我们一次扫描，找到了等于sum的两数后，加上当前遍历到的数字，按顺序存入结果中即可，
 * 然后还要注意跳过重复数字。
 *
 * O(n^2)
 *
 * 对于结果不能重复，常规有两种思路：
 * 1.跳过重复的，遍历第一个数的时候，后面与之相等的跳过。  第二层中，下一个和当前的相等的也略过
 * 2.用Set过滤重复，但是这样需要遍历完整O（n^2） 最差情况可能会超时
 */
public class Sum_3 {



    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> cur = null;

        Arrays.sort(nums);                  //排序

        int target = 0;


        for (int i = 0 ; i < nums.length - 2 ; i ++)
        {

            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i-1]) continue;        //第一层过滤

            cur = new ArrayList<>();
            target = -nums[i];
            cur.add(nums[i]);
            two_sum(cur,target,res,i+1,nums);
            cur.clear();
        }

        return res;

    }

    private  static void two_sum(List<Integer> cur, int target, List<List<Integer>> res, int start, int[] nums)
    {
        int left = start ;
        int right = nums.length - 1;

        while (left < right)
        {

            if (nums[left]+nums[right] == target)
            {
                cur.add(nums[left]);
                cur.add(nums[right]);
                res.add(new ArrayList<>(cur));
                cur.clear();
                cur.add(nums[start - 1]);

                while (left < right &&nums[left+1] == nums[left])
                    left++;
                while (left < right &&nums[right-1] == nums[right])
                    right--;

                left++;
                right--;
            }else if (nums[left]+nums[right] < target)
                left++;
            else
                right--;
        }
    }



    public static void main(String[] args){

        List<List<Integer>> res = threeSum(new int[]{0,0,0});

        System.out.println(res);

    }
}
