package dp.dfs_backtracking查找;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/4/15.
 */
public class leetcode216组合数之和3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        if (n < 1)
            return result;

        List<Integer> curr = new ArrayList<>();
        DFS(result,curr,k,n,1);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> curr, int k, int n, int start) {

        if (k == curr.size())
        {
            if (n==0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }else if (k > curr.size())
        {
            for (int i =start ; i < 10 ; i ++)
            {
                curr.add(i);
                DFS(result,curr,k,n-i,i+1);
                curr.remove(curr.size() - 1);
            }
        }else
            return;

    }
}
