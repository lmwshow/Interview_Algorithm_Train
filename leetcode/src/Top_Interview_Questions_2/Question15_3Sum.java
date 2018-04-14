package Top_Interview_Questions_2;

import java.util.*;

public class Question15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return res;

        List<Integer> cur = new ArrayList<>();
        dfs(res,cur,nums,0,0);

        Set<List<Integer>> set = new HashSet<>();
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;

    }

    private static void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, int target) {

        if (cur.size() == 3)
        {
            if (target == 0) {
                List<Integer> tmp = new ArrayList<>(cur);
                Collections.sort(tmp);
                res.add(tmp);
            }
            return;
        }


        for (int i = start; i < nums.length ; i++)
        {
            cur.add(nums[i]);
            dfs(res,cur,nums,i+1,target + nums[i]);
            cur.remove(cur.size() - 1);
        }

    }


    public static void main(String[] args){

        int nums[] = new int[]{1,-1,-1,0};
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
