package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/29 19:52
 * @Description:
 */
public class 最短无序连续子数组 {

    /*
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     *
     * 从左向右扫描数组，一直更新max，找到最后（数组右侧）一个小于max的数，其下标记为end；
     * 从右向左扫描数组，一直更新min，找到最后（数组左侧）一个大于min的数，其下标记为start；
     * 返回end－start＋1.
     *
     * 如果数组已是ascending状态，需返回0. 为了重用 return end－start＋1，在设置end和start的初始值时应注意相对大小。
     */

    public int findUnsortedSubarray(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return 0;

        int end = -2,start = -1;
        int max = nums[0],min = nums[nums.length - 1];

        for (int i = 0 ; i < nums.length ; i++)
        {
            max = Math.max(nums[i],max);
            if (nums[i] < max)
                end = i;

            min = Math.min(nums[nums.length - 1 - i],min);
            if (nums[nums.length - 1 - i] > min)
                start = nums.length - 1 - i;
        }

        return end - start + 1;
    }
}
