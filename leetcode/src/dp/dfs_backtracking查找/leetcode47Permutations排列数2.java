package dp.dfs_backtracking查找;

import java.util.*;

/**
 * Created by Gracecoder on 2017/4/20.
 */
public class leetcode47Permutations排列数2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {

//        Set<List<Integer>> result = new HashSet<>();             //使用Set 可以去重
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;

        Arrays.sort(nums);
        //这里必须先排序，不然无法通过 while(i+1<nums.length && nums[i] == nums[i+1]) i++; 来去重
        //若使用Set 则可以不需要排序
        List<Integer> curr = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];              //默认为false

        DFS(result,curr,nums,flag);
        return result;
    }

    private static void DFS(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] flag) {

        if (curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0 ; i < nums.length ; i ++)
        {

            if (flag[i] == false)
            {
                flag[i] = true;
                curr.add(nums[i]);
                DFS(result,curr,nums,flag);
                curr.remove(curr.size() - 1);
                flag[i] = false;


                while(i+1<nums.length && nums[i] == nums[i+1]) i++;
            }

        }

    }

    public static void main(String[] args){

        List<List<Integer>> result = new ArrayList<>();
        result = permuteUnique(new int[]{3,3,0,3});

        System.out.println(result.size());
    }
}
