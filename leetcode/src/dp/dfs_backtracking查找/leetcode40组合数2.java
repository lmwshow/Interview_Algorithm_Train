package dp.dfs_backtracking查找;

import java.util.*;

/**
 * Created by Gracecoder on 2017/4/13.
 */
public class leetcode40组合数2 {

    //组合数2和组合数1比：区别在于组合不能重复，dfs能遍历出所有的情况，会存在重复的。   所以我利用了Set的特性先把组合数存下来，再转类型
    public List<List<Integer>> mycombinationSum2(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (target < 0)
            return lists;
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        myDFS(result,curr,candidates,target,0);
        lists.addAll(result);
        return lists;

    }

    private void myDFS(Set<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start) {

        if (target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;

        }else if (target<0)
            return;
        else
            for (int i = start ; i <candidates.length ; i ++)
            {
                curr.add(candidates[i]);
                myDFS(result,curr,candidates,target - candidates[i],i+1);
                curr.remove(curr.size() - 1);
            }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (target < 0 )
            return result;
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(result,curr,candidates,target,0);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start) {
        if (target == 0 )
        {
            result.add(new ArrayList<>(curr));
            return;
        }else if (target < 0)
            return;
        else
            for (int i = start ; i < candidates.length ; i++)
                /*画个图好好理解这层循环的意思,这层循环就是遍历第i层的所有情况 由start到end
                假设当我们递归到n层（B节点）时达到了条件，此时回溯到n-1层(A节点)，而在第n层被（remove）出去的那个点就是candi[i]，此时i++,即下一个元素如何candi[i]相等，
                那么就相当于A节点的下一个儿子节点和上一个大小一样，那就会导致路径相同
                例子比如 递归到[3,2] 然后回溯去掉了2，变成[3]，此时下一个元素又是2，那么加进去就是重复的[3,2]
                */
            {
                if (i > start && candidates[i] == candidates[i-1])
                    continue;                                                       //可以避免重复
                curr.add(candidates[i]);
                DFS(result,curr,candidates,target-candidates[i],i+1);
                curr.remove(curr.size() - 1);                                //回溯
            }

    }
}
