package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/10/30.
 *
 * 这种方法不太行，实际上根本不用管下一个zero_index在哪里， 因为后面的只需要都置为0即可，只用把有价值的填到前面就行了。O(n)
 *
 * 但是两种运行起来时间差不多，因为测试集太小？
 * 第二种明显更加优雅
 */
public class Move_Zeroes {

    public static void moveZeroes(int[] nums) {

        int zero_index = -1;
        for (int i = 0 ; i < nums.length ; i ++)
        {
            if (nums[i]!=0) {
                if (zero_index == -1)
                    continue;
                else {
                    nums[zero_index] = nums[i];
                    nums[i] = 0;
                    while (zero_index <= i)
                    {
                        if (nums[zero_index] == 0)
                            break;
                        else
                            zero_index ++;
                    }
                }
            }
            else
            {
                if (zero_index == -1)
                    zero_index = i;
            }
        }



//        if (nums == null || nums.length == 0) return;
//
//        int insertPos = 0;
//        for (int num: nums) {
//            if (num != 0) nums[insertPos++] = num;
//        }
//
//        while (insertPos < nums.length) {
//            nums[insertPos++] = 0;
//        }




    }


    public static void main(String[] args){


        int[] nums = new int[]{1,2,0,0,0,3,4,0,8,0};
        moveZeroes(nums);

        for (int x: nums)
            System.out.println(x);

    }
}
