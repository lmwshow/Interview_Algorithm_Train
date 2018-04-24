package 拼多多面试4_21;

/**
 * @Auther: minGW
 * @Date: 2018/4/23 09:19
 * @Description: 快排
 */
public class quickSort {


    public static int patition(int[] nums, int left, int right)
    {
        int key = nums[left];

        while(left < right)
        {
            while (left < right && nums[right] >= key)
                right --;
            nums[right] = nums[left];

            while (left < right && nums[left] <= key)
                left ++;
            nums[left] = nums[right];
        }

        nums[left] = key;
        return left;
    }


    public static void quickSort(int[] nums,int left,int right)
    {
        if (left <right)
        {
            int patition = patition(nums,left,right);
            quickSort(nums,left,patition-1);
            quickSort(nums,patition+1,right);
        }
    }

    public static void main(String[] args){

        int[] nums = new int[]{2,3,1,5,9,1,3,4};
        quickSort(nums,0,nums.length-1);
    }
}
