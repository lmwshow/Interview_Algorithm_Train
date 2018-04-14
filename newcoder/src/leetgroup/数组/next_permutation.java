package leetgroup.数组;

import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/8/18.
 */
public class next_permutation {

    //找越后面的 一个数 比 前一位大， 然后互换。 需要找出数组最后面的一个谷底，然后用其后大于它中的最小值与其互换
    public static void nextPermutation(int[] nums) {

        int len = nums.length;
        if (len == 0 || len == 1)
            return;

        int cur = nums[0];
        int targetIndex = -1;           //-1表示 ,一直是递减的  .其他值表示最后面的最低值


        for (int i = 1; i < len ; i++)
        {

            if (nums[i] > cur)
                targetIndex = i - 1;

            cur = nums[i];
        }

        int lastmin = targetIndex;

        if (targetIndex == -1)
            Arrays.sort(nums);
        else
        {
            int k = 0;
            for(k = targetIndex+1 ; k<len;k++)
            {
                if(nums[k]<=nums[lastmin])
                    break;
            }

            if(k!=len)
                targetIndex = k -1;
            else
                targetIndex = len -1;
            int swap = nums[targetIndex];
            nums[targetIndex] = nums[lastmin];
            nums[lastmin] = swap;
        }

        Arrays.sort(nums,lastmin +1,nums.length);         //将lastmin 与 其后面最小的数互换之后，将后面的排列排序成递增

    }

     public static void main(String[] args){

        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);

        for (int x : nums)
            System.out.println(x);


     }
}
