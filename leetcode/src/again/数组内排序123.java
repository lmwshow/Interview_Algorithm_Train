package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/9 19:38
 * @Description:
 */
public class 数组内排序123 {

    //数组内只含有0,1,2,如何单次遍历，是数组有序
    public void sortColors(int[] nums) {

        //维护左右0_index 和 2_index
        if (nums == null || nums.length == 0)
            return;

        int zero_index = 0;
        int two_index = nums.length - 1;

        for (int i = 0 ; i < nums.length ; i++)
        {
            if (nums[i] == 0)
            {
                if (i != zero_index)
                    swap(nums,i,zero_index);

                zero_index ++;
            }else if (nums[i] == 2 && i < two_index)
            {
                swap(nums,i,two_index);
                two_index--;
                i--;        //因为不知道换到当前位置的数字是什么
            }
        }

        return;

    }

    private void swap(int[] nums, int a, int b) {

        int tmp =  nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
