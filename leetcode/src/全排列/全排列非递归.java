package 全排列;

import Top_Interview_Questions_2.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列非递归 {

    //全排列的非递归实现，就是通过不断找下一个序列来实现的，所以需要先排序
    //步骤： 1. 从后往前，找到第一对非递增的相邻的两个数(...i,i+1....)（即 x[i] < x[i+1]）,x[i]记为替换数，i记为替换点
    //      2. 然后从最后往前找到第一个比替换数大的数（这个数必然存在）,将两者交换
    //      3. 最后将替换点之后(i+1 开始)的序列从小到大排序， 其实相当于取逆， 因为本身是递增的



    public static List<List<Integer>> Permutation(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2)
            return res;

        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);

        do{

            for (int x : nums)
                tmp.add(x);
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }while (nextPermutation(nums));

        return res;

    }

    public static boolean nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2)
            return true;

        int i = nums.length - 2;

        for (; i >= 0 ; i--)
        {
            if (nums[i] < nums[i+1]) {
                int find = nums.length-1;
                while (nums[find] <= nums[i])
                    find--;
                swap(nums, i, find);
                reverse(nums,i+1);
                return true;
            }

        }

        reverse(nums,0);
        return false;

    }

    //利用swap 来逆转
    private static void reverse(int[] nums, int start) {

        int end = nums.length - 1;
        while (start < end)
            swap(nums,start++,end--);
        return;
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    public static void main(String[] args){

        int[] nums = new int[]{1,3,2};
        List<List<Integer>> res = Permutation(nums);

        System.out.println(res.size());


    }

}
