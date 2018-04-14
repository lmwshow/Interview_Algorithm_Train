package Top_Interview_Questions_2;

import java.util.Arrays;

public class Question169_求数组中超过一半个数的数字 {


    //O(n) 最快方法  空间复杂度为O(1)
    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;          //表示没有

        int ans = nums[0],time = 1;

        for (int i = 1 ; i < nums.length ;i++)
        {
            if (nums[i]==ans)
                time++;
            else
            {
                time--;
                if (time == 0)
                {
                    ans = nums[i];
                    time = 1;
                }
            }

        }

        return ans;
    }

    //O(nlogn)
    public int sortMajorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}
