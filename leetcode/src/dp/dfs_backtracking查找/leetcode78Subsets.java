package dp.dfs_backtracking查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gracecoder on 2017/4/19.
 */
public class leetcode78Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        DFS(result,curr,nums,0);
        return result;
    }

    private static void DFS(List<List<Integer>> result, List<Integer> curr, int[] nums, int start) {

        result.add(new ArrayList<>(curr));
        for (int i = start ; i < nums.length ; i++)
        {
            curr.add(nums[i]);
            DFS(result,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }


    public static void main(String[] args){

        List<List<Integer>> result = new ArrayList<>();
        result = subsets(new int[]{1,2,3});

        System.out.println("asd");

    }
}

