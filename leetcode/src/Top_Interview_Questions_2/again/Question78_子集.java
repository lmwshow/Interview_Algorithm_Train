package Top_Interview_Questions_2.again;

import java.util.ArrayList;
import java.util.List;

public class Question78_子集 {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null)
            return ans;

        List<Integer> cur = new ArrayList<>();

        dfs(nums,cur,ans,0);

        System.out.println(ans.size());


        return ans;
    }

    private static void dfs(int[] nums, List<Integer> cur, List<List<Integer>> ans, int start) {

        ans.add(new ArrayList<>(cur));

        for (int i = start ; i < nums.length ; i++)
        {
            cur.add(nums[i]);
            dfs(nums,cur,ans,i+1);
            cur.remove(cur.size()-1);
        }


    }


    public static void main(String[] args){

        subsets(new int[]{1,2,3});

    }

}