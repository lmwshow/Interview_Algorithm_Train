package 全排列;

import java.util.ArrayList;
import java.util.List;

public class 去重全排列递归 {

    public static List<List<Integer>> Permutation(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2)
            return res;


        List<Integer> tmp = new ArrayList<>();

        AllPermutation(nums,0,res,tmp);

        return res;

    }

    private static void AllPermutation(int[] nums, int cur, List<List<Integer>> res, List<Integer> tmp) {

        if (cur == nums.length)
        {

            res.add(new ArrayList<>(tmp));

        }else {
            for (int i = cur; i < nums.length; i++)     //第i个数分别与它后面的数字交换就能得到新的排列
            {
                //去重,需要判断 第i个数与第j个数交换时，要求[i,j)中没有与第j个数相等的数
                if (isSwap(nums,cur,i)) {
                    swap(nums, cur, i);
                    tmp.add(nums[cur]);
                    AllPermutation(nums, cur + 1, res, tmp);
                    tmp.remove(tmp.size() - 1);
                    swap(nums, cur, i);
                }
            }
        }

    }

    private static boolean isSwap(int[] nums, int start, int end) {

        for (int i = start ; i < end ; i++)
            if (nums[i] == nums[end])
                return false;
        return true;
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void main(String[] args){

        List<List<Integer>> res = Permutation(new int[]{1,2,3});

        System.out.println(res.size());


    }
}
