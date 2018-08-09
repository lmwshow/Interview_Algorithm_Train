package Top_Interview_Questions_2;

public class Question75_数组On内置排序 {


    //数组内只含有0,1,2,如何单次遍历，是数组有序
    public static void sortColors(int[] nums) {

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

    private static void swap(int[] nums, int a, int b) {

        int tmp =  nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void quicksortColors(int[] nums) {

        if (nums == null || nums.length < 2)
            return;

        quickSort(nums,0,nums.length-1);
    }

    private static void quickSort(int[] nums, int left, int right) {

        if (left >= right)
            return;

        int key = nums[left];
        int start = left;
        int end = right;

        while (left < right)
        {
            while (left < right && nums[right] >= key)
                right--;

            nums[left] = nums[right];
            while (left < right && nums[left] <= key)
                left++;

            nums[right] = nums[left];

        }

        nums[left] = key;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);


    }


    public static void main(String[] args){

        int[] nums = new int[]{3,2,1,1,2,2,3,3,3,3,2,1};

        sortColors(nums);

        for (int x: nums)
            System.out.println(x);



    }
}
