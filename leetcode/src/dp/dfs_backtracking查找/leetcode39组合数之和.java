package dp.dfs_backtracking查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gracecoder on 2017/4/13.
 */
public class leetcode39组合数之和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (target < 0)
            return result;
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);                                    //排序,答案中元素内部必须是升序，所以必须先排序
        DFS(result, curr, candidates, target, 0);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        } else if (target < 0)
            return;
        else
            for (int i = start; i < candidates.length; i++) {
                curr.add(candidates[i]);
                DFS(result, curr, candidates, target - candidates[i], i);             //因为可以重复
                curr.remove(curr.size() - 1);
            }
    }


}
