package Top_Interview_Questions_2;

public class Question215_数组中的第K个最大元素 {

    public static int findKthLargest(int[] nums, int k) {

        int left = 0;
        int right = nums.length-1;
        int ans = Patition(nums,left,right);
        while (ans != nums.length - k)
        {
            if (ans < nums.length - k)
                ans = Patition(nums,ans+1,right);
            else
                ans = Patition(nums,left,ans-1);
        }

        return nums[ans];
    }

    public static int Patition(int[] nums,int start,int end)
    {
        int key = nums[start];

        //因为对于每次循环 都要进行一次交换，加等于号可能会约过边界
        while (start < end)
        {
            while (end > start && nums[end] >= key)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= key)
                start++;
            nums[end] = nums[start];
        }

        nums[start] = key;
        return start;
    }


    public static void main(String[] args){

        System.out.println(findKthLargest(new int[]{1},1));


    }
}
