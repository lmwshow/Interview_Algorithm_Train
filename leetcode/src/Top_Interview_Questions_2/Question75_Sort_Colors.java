package Top_Interview_Questions_2;

public class Question75_Sort_Colors {

    public static void sortColors(int[] nums) {

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
