package Top_Interview_Questions_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question39_组合和 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> anslist = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return anslist;

        List<Integer> curlist = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates,0,0,target,curlist,anslist);

        return anslist;

    }

    private static void dfs(int[] candidates,int start,int cursum,int target, List<Integer> curlist,List<List<Integer>> anslist) {

        if (cursum >= target) {
            if (cursum == target)
                anslist.add(new ArrayList<>(curlist));
            return;
        }

        for (int i = start ; i < candidates.length ; i++)
        {
            if (candidates[i] > target)
                return;

            curlist.add(candidates[i]);
            dfs(candidates,i,cursum+candidates[i],target,curlist,anslist);
            curlist.remove(curlist.size()-1);
        }



    }


    public static void main(String[] args){

        List<List<Integer>> anslist = combinationSum(new int[]{2,3,6,7},7);

        System.out.println(anslist);

    }
}
