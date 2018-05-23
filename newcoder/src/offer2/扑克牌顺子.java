package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/19 09:26
 * @Description: https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 大小王可变，判断5张数是不是顺着。为了方便起见,你可以认为大小王是0。
 */

public class 扑克牌顺子 {

    static int[] nums;
    static int min;
    static int max;
    public boolean isContinuous(int [] numbers) {

        if (numbers == null || numbers.length < 5)
            return false;
        nums = new int[14];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int x : numbers)
            nums[x] ++;

        for (int i = 1 ; i < nums.length; i++)
        {
            int cur = nums[i];
            if (cur == 0)
                continue;

            if (cur > 1)
                return false;               //其他牌为多张，不可能为顺子

            max = i > max?i:max;
            min = i < min?i:min;
        }

        for (int i = min+1 ; i < max ; i++)
        {
            if (nums[i] == 0)
            {
                nums[0]--;
                if (nums[0] < 0)
                    return false;
            }
        }

        return true;

    }
}
