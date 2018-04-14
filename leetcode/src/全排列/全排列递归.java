package 全排列;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列递归 {



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
                swap(nums,cur,i);
                tmp.add(nums[cur]);
                AllPermutation(nums,cur+1,res,tmp);
                tmp.remove(tmp.size()-1);
                swap(nums,cur,i);
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void main(String[] args){

        List<List<Integer>> res = Permutation(new int[]{1,2,2});

        System.out.println(res.size());


    }

}
