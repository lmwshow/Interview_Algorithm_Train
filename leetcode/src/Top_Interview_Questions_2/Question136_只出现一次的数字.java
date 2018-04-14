package Top_Interview_Questions_2;

import java.util.Map;

public class Question136_只出现一次的数字 {

    static int ans;
    //异或运算
    public int singleNumber(int[] nums) {

        ans = 0;

        if (nums == null || nums.length == 0)
            return ans;

        for (int x: nums)
            ans ^= x;

        return ans;
    }
}
