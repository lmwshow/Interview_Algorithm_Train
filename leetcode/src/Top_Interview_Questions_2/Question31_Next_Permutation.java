package Top_Interview_Questions_2;

import java.util.Arrays;
import java.util.Collections;

public class Question31_Next_Permutation {

    //全排列的非递归实现，就是通过不断找下一个序列来实现的
    //步骤： 1. 从后往前，找到第一对非递增的相邻的两个数(...i,i+1....)（即 x[i] < x[i+1]）,x[i]记为替换数，i记为替换点
    //      2. 然后从最后往前找到第一个比替换数大的数（这个数必然存在）,将两者交换
    //      3. 最后将替换点之后(i+1 开始)的序列从小到大排序， 其实相当于取逆， 因为本身是递增的

    public static void nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2)
            return;

        int i = nums.length - 2;

        for (; i >= 0 ; i--)
        {
            if (nums[i] < nums[i+1]) {
                int find = nums.length-1;
                while (nums[find] <= nums[i])
                    find--;
                swap(nums, i, find);
                reverse(nums,i+1);
                return;
            }

        }

        reverse(nums,0);

    }

    private static void reverse(int[] nums, int start) {

        int[] copy = nums.clone();
        int index = start;
        for (int i = nums.length - 1 ; i >= start ; i--)
            copy[index++] = nums[i];

        for (int i = start ; i < nums.length ; i++)
            nums[i] = copy[i];
        return;
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    public static void main(String[] args){

        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);

        for (int x :
                nums) {
            System.out.println(x);

        }



    }

}
