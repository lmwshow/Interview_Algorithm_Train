package dp.dfs_backtracking查找;

import java.util.*;

/**
 * Created by Gracecoder on 2017/4/19.
 */
public class leetcode46Permutations排列数 {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();                 //Set是无序的，remove时给index，不一定会删除哪个
        DFS(result, curr, nums);

        return result;
    }

    private static void DFS(List<List<Integer>> result, List<Integer> curr, int[] nums) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;               //跳过已经含有的
            curr.add(nums[i]);
            DFS(result, curr, nums);
            curr.remove(curr.size() - 1);
        }

    }


    public static int func() {
        int x;

        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;

        }finally {
            x = 3;
        }

    }

    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();
        result = permute(new int[]{1, 2, 3});



        System.out.println(func());


    }
}
