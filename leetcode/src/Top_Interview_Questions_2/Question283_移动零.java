package Top_Interview_Questions_2;

public class Question283_移动零 {

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0)
            return;

        int index = 0;

        for (int i = 0 ; i < nums.length ;i++)
        {
            if (nums[i]!=0)
                nums[index++] = nums[i];
        }
        for (;index < nums.length ; index++)
            nums[index] = 0;

        return;

    }
}
